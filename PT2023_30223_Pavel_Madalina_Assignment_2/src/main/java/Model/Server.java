package Model;

import Model.Client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

///clasa asta reprezinta defapt coada
public class Server implements Runnable {
    private BlockingQueue<Client> queueClients; //clientii de la o coada
    private AtomicInteger waitingPeriod; //perioada de asteptare la o coada(suma de servingTime al clientilor)
    private boolean qOpen;// va fi true daca avem cel putin un client in coada
    private static float timeW=0;
    private static float timeS=0;
    public Server()
    {
        this.queueClients=new LinkedBlockingQueue<Client>();
        this.waitingPeriod=new AtomicInteger(0);
        this.qOpen=true;

    }

    public static float getTimeS() {
        return timeS;
    }

    public void addClients(Client newClient)
    {
        queueClients.add(newClient);
        timeW += this.waitingPeriod.get() + newClient.gettService();
        timeS+=newClient.gettService();
        this.waitingPeriod.getAndAdd(newClient.gettService());

    }

    public  static float getTimeW() {
        return timeW;
    }
    public int isEmpty()
    {
        if(queueClients.isEmpty())
            return 1;
        else
            return 0;
    }



    public void run()
    {
        Client cl = null;


        while(true) {
            if(!queueClients.isEmpty()) {


                try {
                    cl = queueClients.element();
                    Thread.sleep(1000); // opriți thread-ul pentru 1 secunda


                if (cl.gettService() == 1) //daca a ajuns la timpul de servire=1 inseamna ca a ajuns la "casa"
                {
                    queueClients.remove(cl);


                }
                else
                    cl.settService(cl.gettService()-1);

                waitingPeriod.decrementAndGet();




                } catch (InterruptedException e) {
                    e.printStackTrace();


                }


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
        return waitingPeriod.get();
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public boolean isqOpen() {
        return qOpen;
    }

    public void setqOpen(boolean qOpen) {
        this.qOpen = qOpen;
    }
}
