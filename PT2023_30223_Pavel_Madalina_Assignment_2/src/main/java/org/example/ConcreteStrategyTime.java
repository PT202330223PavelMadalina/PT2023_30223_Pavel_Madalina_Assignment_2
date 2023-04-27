package org.example;

import Model.Client;
import Model.Server;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    @Override
    public void addClient(List<Server> queues, Client c) {
        int minim=queues.get(0).getWaitingPeriod();
        Server cMinim=queues.get(0);

        for(Server queue:queues)
        {

            if(queue.getWaitingPeriod()<minim)
            {
                minim=queue.getWaitingPeriod();
                cMinim=queue;
            }
        }
        //System.out.println(cMinim.getWaitingPeriod());

        cMinim.addClients(c);

    }
}
