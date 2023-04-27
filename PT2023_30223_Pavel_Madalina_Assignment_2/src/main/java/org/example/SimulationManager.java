package org.example;

import Model.Client;
import Model.Server;
import View.Designer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationManager implements Runnable {
    private int nbClients;
    private int nbQueues;
    private int simInterval;

    private int minArrival;
    private int maxArrival;
    private int minService;
    private int maxService;
    private String stringAf;
    private Scheduler scheduler;
    private List<Client> listOfClients;//toti clientii
    private List<Server> listOfQueues;//toate cozile
    private boolean qOpen;
    public SimulationManager(int nbClients,int nbQueues, int simInterval, int minArrival,int maxArrival,int minService,int maxService)
    {
        this.qOpen=true;
        this.scheduler=new Scheduler(nbQueues,nbClients);
        this.nbQueues=nbQueues;
        this.nbClients=nbClients;
        this.simInterval=simInterval;
        this.minArrival=minArrival;
        this.maxArrival=maxArrival;
        this.minService=minService;
        this.maxService=maxService;
        listOfClients=new ArrayList<Client>(nbClients);
        generateRandomClients();
        listOfQueues=scheduler.getListOfQueues();


    }

    public void generateRandomClients()
    {
         Random r=new Random();
         for(int i=0;i<nbClients;i++)
        {
         int randomId=i;
        int randomTArrival=r.nextInt((maxArrival-minArrival)+1)+minArrival;
        int randomTService=r.nextInt((maxService-minService)+1)+minService;
        Client c=new Client(randomId,randomTArrival,new AtomicInteger(randomTService));
        listOfClients.add(c);
        //int doi=2;

        /*Client c1=new Client(1,2, new AtomicInteger(2));
        Client c2=new Client(2,2,new AtomicInteger(3));
        Client c3=new Client(3,2,new AtomicInteger(3));
        Client c4=new Client(4,10,new AtomicInteger(2));
        listOfClients.add(c1);
        listOfClients.add(c2);
        listOfClients.add(c3);
        listOfClients.add(c4);

         */
         }


        Collections.sort(listOfClients);
    }


    public String printInt(int time) {
        String s="---------------------------";
        s += "TIME  " + time+"--------------------------------";
        s += "\nWaiting clients: ";
        for (Client c : listOfClients) {
            s += "(" + c.getId() + "," + c.gettArrival() + "," + c.gettService() + "); ";
        }
        if (listOfClients.size() == 0)
            s += "no more waiting clients";
        s+="\n";

        for (Server queue : listOfQueues) {
            BlockingQueue<Client> clients = queue.getQueueClients();
            int i = listOfQueues.indexOf(queue) + 1;
            s += "Queue" + i + " : ";
            for (Client c : clients) {
                s += "(" + c.getId() + "," + c.gettArrival() + "," + c.gettService() + "); ";
            }
            if (clients.size() == 0)
            {
                s += "closed";

            }
            s+="\n";

        }
        s += "\n";
        return s;
    }

    public void writeToFile(String fileName, String content) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("A aparut o eroare.");
            e.printStackTrace();
        }
    }

    public void Print1(int currentTime) {
        System.out.println();
        System.out.println("TIME  " + currentTime);
        System.out.print("Waiting clients: ");
        for (Client c : listOfClients) {

            System.out.print("(" + c.getId() + "," + c.gettArrival() + "," + c.gettService() + "); ");
        }
        if (listOfClients.size() == 0)
        {
            System.out.print("no more waiting clients");
        }
        System.out.println();
        for (Server queue : listOfQueues) {
            BlockingQueue<Client> clients = queue.getQueueClients();
            int index = listOfQueues.indexOf(queue) + 1;
            System.out.print("Queue" + index + " : ");
            for (Client c : clients) {
                System.out.println("(" + c.getId() + "," + c.gettArrival() + "," + c.gettService() + "); ");
            }
            if (clients.size() == 0)
                System.out.println("closed");

        }
    }

    public String getStringAf() {
        return stringAf;
    }

    public void run() {
        int currentTime=0;
        int max=0;
        int ora=0;
        String stringt1="";

        while(currentTime<simInterval && (!listOfClients.isEmpty() || !scheduler.isEmpty()))
        {

            int clientsperHour=0;
            while( !listOfClients.isEmpty() && listOfClients.get(0).gettArrival()==currentTime)//pt cazul cu mai multi clienti care au acelasi tArrival
            {

                clientsperHour++;

                scheduler.dispatchClients(listOfClients.get(0));



                listOfClients.remove(listOfClients.get(0));


            }

            if(clientsperHour>max)
            {max=clientsperHour;
                ora=currentTime;}
            Print1(currentTime);
            stringAf=printInt(currentTime);
             stringt1 += printInt(currentTime);
            Designer.getTextArea1().append(stringAf);
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }



        }

        float averageWaitingTime=Server.getTimeW()/nbClients;
        float averageServiceTime=Server.getTimeS()/nbClients;
        System.out.println("Timpul mediu de asteptare este: "+averageWaitingTime);
        String ss="Timpul mediu de asteptare este: "+ Float.toString(averageWaitingTime);
        Designer.getTextArea1().append(ss);
        System.out.println("Timpul mediu de servire este: "+averageServiceTime);
        String ts="Timpul mediu de servire este: "+ Float.toString(averageServiceTime);
        Designer.getTextArea1().append("\n"+ts);

        System.out.println("Ora de varf este: "+ora);
        String ov="Ora de varf este: "+ Integer.toString(ora);
        Designer.getTextArea1().append("\n"+ov);
        writeToFile("testtest.txt",stringt1);
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

    public boolean isqOpen() {
        return qOpen;
    }

    public void emptyQueues()
    {
        int ok=0;
        for(int i=0;i<nbQueues;i++)
        {
            if(listOfQueues.get(i).isEmpty()==0)
                this.setqOpen(true);
        }
        this.setqOpen(false);
    }

    public void setqOpen(boolean qOpen) {
        this.qOpen = qOpen;
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
