package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class VapoareController {
    private VapoareModel m_model;
    private VapoareModel m_modelInamic;
    private VapoareView m_view;
    private VapoareView2 m_view2;

    public VapoareController(VapoareModel model, VapoareModel modelInamic, VapoareView view, VapoareView2 view2) {
        m_model = model;
        m_view = view;
        m_view2 = view2;
        m_modelInamic = modelInamic;
        m_model.getHv().initHarta();
        m_modelInamic.getHv().initHarta();
        setVapoareInamic();
        view.addNameListener(new NameListener());
        view.addOpenListener(new OpenListener());
        view2.addAddBoatListener1(new AddBoatListener());
        view2.addKillBoatListener(new KillBoatListener());
    }

    class NameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            userInput = m_view.getM_name();
            m_view.setNamee(userInput);
            m_view.getM_gobtn().setVisible(false);
            m_view.getM__name().setEditable(false);
        }
    }

    class OpenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            m_view2.setVisible(true);
            m_view.setVisible(false);
        }
    }

    class AddBoatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton o = (JButton) e.getSource();
            JLabel oIcon = new JLabel(o.getIcon());
            JLabel waterIcon = new JLabel(new ImageIcon(("water.png")));
            if (m_model.getNrVapoare() <= 2 && oIcon.getIcon().toString().equals(waterIcon.getIcon().toString()))  {
                o.setIcon(new ImageIcon("boat.png"));
                m_model.setNrVapoare(m_model.getNrVapoare() + 1);
                m_model.getArray().set(Integer.parseInt(o.getName()), 0);
            }
                if (m_model.getNrVapoare() == 3) {
                    for (int i = 1; i <= 25; i++)
                        m_view2.getEnemyMap()[i].setVisible(true);
                    m_view2.plsBoats.setText("You start. Please allow the computer 5 sec to make a choice");
                }
               // m_model.getHv().showVapoare();
        }
    }
    class KillBoatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                JButton o = (JButton) e.getSource();
                JLabel oIcon = new JLabel(o.getIcon());
                JLabel waterIcon = new JLabel(new ImageIcon(("water.png")));
                if(oIcon.getIcon().toString().equals(waterIcon.getIcon().toString())) {
                    if (m_modelInamic.getArray().get(Integer.parseInt(o.getName())) == 0) {
                        System.out.println(Integer.parseInt(o.getName()));
                        o.setIcon(new ImageIcon("deadboat.png"));
                        m_modelInamic.getArray().set(Integer.parseInt(o.getName()), 1); //pun 1 unde lovesc
                        m_modelInamic.setStillAlive(m_modelInamic.getStillAlive() - 1);
                        System.out.println("Lovit");
                    } else o.setIcon(new ImageIcon("noboat.png"));
                    if (m_modelInamic.getStillAlive() == 0) {
                        System.out.println("Ai castigat");
                        m_view2.showWinner(true);
                    }
                    //randul computerului;
                    waitABit();
                }
        }
    }
    private void waitABit(){
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> handle = scheduler.schedule(new Runnable() {
                    public void run() {
                        try {
                            computerTurn();
                        } catch ( Exception e ) {
                            System.out.println("Error");
                        }
                    }
                }, 2,  TimeUnit.SECONDS);
    }
    public void computerTurn(){

        if(m_model.getStillAlive() == 0)
            System.out.println("Ai pierdut");

        else if( m_modelInamic.getStillAlive() != 0) {
            int pozitie = (int) (Math.random() * 24 + 1);
            while( m_model.getArray().get(pozitie) == 1 || m_model.getArray().get(pozitie) == -2 )
                pozitie = (int) (Math.random() * 24 + 1); //verific sa nu lovesc unde am lovit deja
            if (m_model.getArray().get(pozitie) == 0) {
                m_view2.myMap[pozitie].setIcon(new ImageIcon("deadboat.png"));
                m_model.getArray().set(pozitie, 1); //pun 1 unde lovesc
                m_model.setStillAlive(m_model.getStillAlive() - 1);
            } //m-a lovit PC ul
            else if (m_model.getArray().get(pozitie) == -1)
                m_view2.myMap[pozitie].setIcon(new ImageIcon("greenx.png"));
                m_model.getArray().set(pozitie, -2); //pun -2 unde nu gasesc nimic
            // nu m-a gasit pc-ul sa ma loveasca
        }
        if(m_model.getStillAlive() == 0) {
            System.out.println("Ai pierdut");
            m_view2.showWinner(false);
        }
    }

    public void setVapoareInamic(){
        for(int i=0;i<3;i++) {
            int pozitie = (int) (Math.random() * 24 + 1);
            while( m_modelInamic.getArray().get(pozitie) == 0 )
                pozitie = (int) (Math.random() * 24 + 1);
            m_modelInamic.getArray().set(pozitie,0);
        }
        m_modelInamic.getHv().showVapoare();
    }
}
