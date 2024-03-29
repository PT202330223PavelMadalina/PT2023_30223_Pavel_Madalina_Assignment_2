package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Client implements Comparable{
    private int id;
    private int tArrival;
    private AtomicInteger tService;

    public Client(int id, int tArrival, AtomicInteger tService)
    {
        this.id=id;
        this.tArrival=tArrival;
        this.tService=tService;
    }

    public int compareTo(Object o) {
        Client c=(Client) o;
        return this.tArrival-c.tArrival;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void settArrival(int tArrival) {
        this.tArrival = tArrival;
    }

    public void settService(int tService) {
        this.tService = new AtomicInteger(tService);
    }

    public int gettArrival() {
        return tArrival;
    }

    public int gettService() {
        return tService.intValue();
    }




}
