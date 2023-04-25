package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    public Controller() {
        Designer ff = new Designer();
        ff.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationManager s=new SimulationManager(Integer.parseInt(ff.getT1().getText()),Integer.parseInt(ff.getT2().getText()),Integer.parseInt(ff.getT3().getText()),Integer.parseInt(ff.getT4().getText()),Integer.parseInt(ff.getT5().getText()),Integer.parseInt(ff.getT6().getText()),Integer.parseInt(ff.getT7().getText()));


                //s.generateRandomClients();
                //s.queuesGenerator();
                Thread t=new Thread(s);
                t.start();


            }
        });
    }
}
