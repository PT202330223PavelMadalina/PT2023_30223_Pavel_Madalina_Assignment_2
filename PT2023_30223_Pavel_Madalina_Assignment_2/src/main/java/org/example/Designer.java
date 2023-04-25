package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Designer {
    public Designer() {

        JFrame frame = new JFrame("QUEUE MANAGEMENT APPLICATION");

        panel1.setBounds(0,0,700,500);
        panel1.setBackground(new Color(135,206,250));
        panel1.setLayout(null);
        l1.setBounds(250,0,300,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(new Color(70,130,180));
        panel1.add(l1);

        t1.setBounds(150,50,50,30);
        panel1.add(t1);
        l2.setBounds(20,50,100,30);
        l2.setFont(new Font("serif",Font.ITALIC,17));
        l2.setForeground(new Color(70,130,180));
        panel1.add(l2);
        t2.setBounds(150,100,50,30);
        panel1.add(t2);
        l3.setBounds(20,100,100,30);
        l3.setFont(new Font("serif",Font.ITALIC,17));
        l3.setForeground(new Color(70,130,180));
        panel1.add(l3);

        t3.setBounds(150,150,50,30);
        panel1.add(t3);
        l4.setBounds(20,150,100,30);
        l4.setFont(new Font("serif",Font.ITALIC,17));
        l4.setForeground(new Color(70,130,180));
        panel1.add(l4);

        t4.setBounds(150,200,50,30);
        panel1.add(t4);
        l5.setBounds(20,200,100,30);
        l5.setFont(new Font("serif",Font.ITALIC,17));
        l5.setForeground(new Color(70,130,180));
        panel1.add(l5);

        t5.setBounds(150,250,50,30);
        panel1.add(t5);
        l6.setBounds(20,250,100,30);
        l6.setFont(new Font("serif",Font.ITALIC,17));
        l6.setForeground(new Color(70,130,180));
        panel1.add(l6);

        t6.setBounds(150,300,50,30);
        panel1.add(t6);
        l7.setBounds(20,300,100,30);
        l7.setFont(new Font("serif",Font.ITALIC,17));
        l7.setForeground(new Color(70,130,180));
        panel1.add(l7);

        t7.setBounds(150,350,50,30);
        panel1.add(t7);
        l8.setBounds(20,350,100,30);
        l8.setFont(new Font("serif",Font.ITALIC,17));
        l8.setForeground(new Color(70,130,180));
        panel1.add(l8);


        addButton.setBackground(new Color(0,0,128));
        addButton.setForeground(Color.white);
        addButton.setBounds(210,400,200,30);
        panel1.add(addButton);


        t8.setBounds(300,50,300,320);
        t8.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        t8.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel1.add(t8);






        frame.setBounds(0, 0, 700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel1);
        frame.setVisible(true);





    }

    JFrame f;
    JPanel panel1=new JPanel();
    private Label l1=new Label("SIMULATION");
    private Label l2=new Label("N:");
    private Label l4=new Label("Time:");
    private Label l5=new Label("TMinArrival:");
    private Label l7=new Label("TMinService:");
    private Label l6=new Label("TMaxArrival:");
    private Label l8=new Label("TMaxService:");
    private JTextField t1=new JTextField();
    private JTextField t2=new JTextField();
    private JTextField t3=new JTextField();

    public JTextField getT9() {
        return t9;
    }

    public void setT9(JTextField t9) {
        this.t9 = t9;
    }

    public static JTextArea getTextArea1() {
        return textArea1;
    }



    public JScrollPane getT8() {
        return t8;
    }

    public void setT8(JScrollPane t8) {
        this.t8 = t8;
    }

    public JScrollPane getScrollableTextArea1() {
        return scrollableTextArea1;
    }

    public void setScrollableTextArea1(JScrollPane scrollableTextArea1) {
        this.scrollableTextArea1 = scrollableTextArea1;
    }

    private JTextField t4=new JTextField();
    private JTextField t5=new JTextField();

    private JTextField t9=new JTextField();
   private static JTextArea textArea1=new JTextArea(30,30);
   private JScrollPane t8=new JScrollPane(textArea1);
   private  JScrollPane scrollableTextArea1;

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }

    public Label getL4() {
        return l4;
    }

    public void setL4(Label l4) {
        this.l4 = l4;
    }

    public Label getL5() {
        return l5;
    }

    public void setL5(Label l5) {
        this.l5 = l5;
    }

    public Label getL7() {
        return l7;
    }

    public void setL7(Label l7) {
        this.l7 = l7;
    }

    public Label getL6() {
        return l6;
    }

    public void setL6(Label l6) {
        this.l6 = l6;
    }

    public Label getL8() {
        return l8;
    }

    public void setL8(Label l8) {
        this.l8 = l8;
    }

    public JTextField getT4() {
        return t4;
    }

    public void setT4(JTextField t4) {
        this.t4 = t4;
    }

    public JTextField getT5() {
        return t5;

    }

    public void setT5(JTextField t5) {
        this.t5 = t5;
    }

    public JTextField getT6() {
        return t6;
    }

    public void setT6(JTextField t6) {
        this.t6 = t6;
    }

    public JTextField getT7() {
        return t7;
    }

    public void setT7(JTextField t7) {
        this.t7 = t7;
    }

    private JTextField t6=new JTextField();
    private JTextField t7=new JTextField();
    private JButton addButton=new JButton("START SIMULATION");

    private Label l3=new Label("Q:");

    public void setL1(Label l1) {
        this.l1 = l1;
    }

    public void setL2(Label l2) {
        this.l2 = l2;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public void setT3(JTextField t3) {
        this.t3=t3;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }


    public void setL3(Label l3) {
        this.l3 = l3;
    }

    public Label getL1() {
        return l1;
    }

    public Label getL2() {
        return l2;
    }

    public JTextField getT1() {
        return t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public JButton getAddButton() {
        return addButton;
    }


    public Label getL3() {
        return l3;
    }

    public void appendToTextarea(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                textArea1.append(message);
            }
        });
    }

}
