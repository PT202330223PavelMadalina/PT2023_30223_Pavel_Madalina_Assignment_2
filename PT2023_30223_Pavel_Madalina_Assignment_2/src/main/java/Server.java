import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
///clasa asta reprezinta defapt coada
public class Server extends Thread {
    private BlockingQueue<Client> queueClients; //clientii de la o coada
    private int waitingPeriod; //perioada de asteptare la o coada(suma de servingTime al clientilor)
    private boolean qOpen;// va fi true daca avem cel putin un client in coada
    public Server()
    {
        this.waitingPeriod=0;
        this.qOpen=false;
    }
    public void addClients(Client newClient)
    {
        queueClients.add(newClient);
        this.qOpen=true;
        this.waitingPeriod=this.waitingPeriod+ newClient.gettService();
    }


    public void run()
    {
        while(qOpen==true)
        {
            try {
                Client cl=queueClients.take();
                if(cl.gettService()==1) //daca a ajuns la timpul de servire=1 inseamna ca a ajuns la "casa"
                {
                    queueClients.remove(cl);
                    this.waitingPeriod=this.waitingPeriod-cl.gettService();
                    if(queueClients.isEmpty())
                    {
                        this.qOpen=false;
                    }

                }
                else
                {
                    cl.settService(cl.gettService()-1);
                    this.waitingPeriod=this.waitingPeriod-1;
                }
                try {
                    Thread.sleep(1000); // opriți thread-ul pentru 1 secunda
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
    public BlockingQueue<Client> getQueueClients() {
        return queueClients;
    }

    public void setQueueClients(BlockingQueue<Client> queueClients) {
        this.queueClients = queueClients;
    }

    public int getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(int waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public boolean isqOpen() {
        return qOpen;
    }

    public void setqOpen(boolean qOpen) {
        this.qOpen = qOpen;
    }
}
