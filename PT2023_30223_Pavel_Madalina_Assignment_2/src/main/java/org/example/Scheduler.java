package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> listOfQueues;
    private int maxNoQueues;
    private int maxClientsPerQueue;
    private Strategy strategy;

    public Scheduler(int maxNoQueues, int maxClientsPerQueue)
    {
        this.strategy=new ConcreteStrategyTime();

        this.maxNoQueues=maxNoQueues;
        this.maxClientsPerQueue=maxClientsPerQueue;
        listOfQueues=new ArrayList<Server>(maxClientsPerQueue);
        for(int i=0;i<maxNoQueues;i++)
        {
            Server c=new Server();
            listOfQueues.add(c);
            Thread t=new Thread(c);
            t.start();
        }
    }



    public List<Server> getListOfQueues() {
        return listOfQueues;
    }

    public void setListOfQueues(List<Server> listOfQueues) {
        this.listOfQueues = listOfQueues;
    }

    public int getMaxNoQueues() {
        return maxNoQueues;
    }

    public void setMaxNoQueues(int maxNoQueues) {
        this.maxNoQueues = maxNoQueues;
    }

    public int getMaxClientsPerQueue() {
        return maxClientsPerQueue;
    }

    public void setMaxClientsPerQueue(int maxClientsPerQueue) {
        this.maxClientsPerQueue = maxClientsPerQueue;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void dispatchClients(Client c)
    {
        strategy.addClient(listOfQueues,c);
    }
}
