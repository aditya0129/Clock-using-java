package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;

public class MyWindow extends JFrame
{
    private  JLabel heading;
    private  JLabel ClockLabel;
    private  Font font=new Font("",Font.BOLD,35);
    MyWindow(){
        super.setTitle("My Clock");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.createGUI();
        this.startclock();
        super.setVisible(true);
    }
    public void createGUI()
    {
        heading=new JLabel("My Clock");
        ClockLabel=new JLabel("Clock");
        heading.setFont(font);
        ClockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));

        this.add(heading);
        this.add(ClockLabel);

    }
    public void startclock()

    {
        /*Timer timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   String datetime=new Date().toString();
                //String datetime=new Date().toLocaleString();

                //Date d=new Date();

                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");

                //String dateTime=sdf.format(d);
                        Date d=new Date();
                       String dateTime= sdf.format(d);


                ClockLabel.setText(dateTime);
            }
        });*/

      //  timer.start();


        Thread t=new Thread() {
            public void run(){
                try{
                    while(true){
                        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");

                        Date d=new Date();
                        String dateTime= sdf.format(d);


                        ClockLabel.setText(dateTime);
                        Thread.sleep(1000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        };
        t.start();
    }

}
