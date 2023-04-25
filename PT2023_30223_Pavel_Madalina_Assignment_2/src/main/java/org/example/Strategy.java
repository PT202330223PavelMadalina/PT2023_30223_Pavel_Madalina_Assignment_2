package org.example;

import java.util.List;

public interface Strategy {
    public void addClient(List<Server> queues, Client c);
}
