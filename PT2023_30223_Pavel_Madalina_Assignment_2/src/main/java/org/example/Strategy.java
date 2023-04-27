package org.example;

import Model.Client;
import Model.Server;

import java.util.List;

public interface Strategy {
    public void addClient(List<Server> queues, Client c);
}
