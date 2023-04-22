import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulationManager extends Thread{
    private int nbClients;
    private int nbQueues;
    private int simInterval;

    private int minArrival;
    private int maxArrival;
    private int minService;
    private int maxService;
    private List<Client> listOfClients;//toti clientii
    private List<Server> listOfQueues;//toate cozile
    public SimulationManager()
    {
        for(int i=0;i<nbQueues;i++)
            listOfQueues.add(new Server());

        for(int i=0;i<nbQueues;i++)
            listOfQueues.get(i).start();
    }

    public void generateRandomClients()
    {
        Random r=new Random();
        for(int i=0;i<nbClients;i++)
        {
           int randomId=r.nextInt(nbClients)+1;
           int randomTArrival=r.nextInt((maxArrival-minArrival)+1)+minArrival;
           int randomTService=r.nextInt((maxService-minService)+1)+minService;
           Client c=new Client(randomId,randomTArrival,randomTService);
           listOfClients.add(c);
        }
        Collections.sort(listOfClients);
    }

    public int fastestQueue()
    {
        int minim=listOfQueues.get(0).getWaitingPeriod();
        int iMinim=0;
        for(int i=1;i<nbQueues;i++)
        {
            if(listOfQueues.get(i).getWaitingPeriod()<minim)
            {
                minim=listOfQueues.get(i).getWaitingPeriod();
                iMinim=i;
            }
        }
        return iMinim;
    }
    public List<Client> copie()
    {
        List<Client> copieClieti = new ArrayList<>(nbClients);
        for(int i=0;i<nbClients;i++)
        {
            copieClieti.add(listOfClients.get(i));
        }
        return copieClieti;
    }

    public void run()
    {
         int currentTime=0;
         List<Client> cop=copie();//copie a listei de clienti
         while(currentTime<simInterval)
         {
             for(int i=0;i<nbClients;i++)
             {
                 if(cop.get(i).gettArrival()==currentTime)
                 {
                     int iMinim=fastestQueue();
                     listOfQueues.get(iMinim).addClients(cop.get(i));
                     listOfClients.remove(cop.get(i));
                 }
             }
             currentTime++;
             try {
                 sleep(1000);
             } catch (InterruptedException e) {
                 e.getStackTrace();
             }
         }
    }

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public int getNbQueues() {
        return nbQueues;
    }

    public void setNbQueues(int nbQueues) {
        this.nbQueues = nbQueues;
    }

    public int getSimInterval() {
        return simInterval;
    }

    public void setSimInterval(int simInterval) {
        this.simInterval = simInterval;
    }

    public int getMinArrival() {
        return minArrival;
    }

    public void setMinArrival(int minArrival) {
        this.minArrival = minArrival;
    }

    public int getMaxArrival() {
        return maxArrival;
    }

    public void setMaxArrival(int maxArrival) {
        this.maxArrival = maxArrival;
    }

    public int getMinService() {
        return minService;
    }

    public void setMinService(int minService) {
        this.minService = minService;
    }

    public int getMaxService() {
        return maxService;
    }

    public void setMaxService(int maxService) {
        this.maxService = maxService;
    }

}
