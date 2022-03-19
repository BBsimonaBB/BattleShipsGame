package com.company;

import javax.swing.*;
import java.awt.*;

public class VapoareView2 extends JFrame {
    private VapoareModel m_model;
    JLabel plsBoats = new JLabel( "Please enter your boats...");
    JLabel aiCastigat = new JLabel("Ai castigat !");
    JLabel aiPierdut = new JLabel("Ai pierdut !");
    JButton[] myMap = new JButton[26];
    JButton[] enemyMap = new JButton[26];
    ImageIcon vaporIcon = new ImageIcon("vapor.png");
    JLabel vaporLabel = new JLabel(vaporIcon);

    VapoareView2(VapoareModel model)
    {
        m_model = model;

        Color color_background = new Color(231,254,255);

        JPanel content = new JPanel();
        content.setBackground(color_background);
        content.setLayout(null);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Vapoare");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);

        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);
        Font f2 = new Font(Font.SANS_SERIF,  Font.BOLD | Font.ITALIC, 60);

        makeButtons(content);
        makeButtons2(content);
        plsBoats.setFont(f1);
        plsBoats.setBounds(30,100,1000,15);
        content.add(plsBoats);
        content.add(aiCastigat);
        content.add(aiPierdut);
        aiPierdut.setFont(f2);
        aiCastigat.setFont(f2);
        aiPierdut.setBounds(100,100,500,70);
        aiCastigat.setBounds(100,100,500,70);
        aiCastigat.setVisible(false);
        aiPierdut.setVisible(false);

        vaporLabel.setBounds(100,100,1100,500);
        content.add(vaporLabel);
        vaporLabel.setVisible(false);

    }

    public void makeButtons(JPanel content){
        for(int i=1;i<=5;i++)
            for(int j=1;j<=5;j++){
            myMap[i*5+j-5] = new JButton(new ImageIcon("water.png"));
            myMap[i*5+j-5].setName(String.valueOf(i*5+j-5));
            myMap[i*5+j-5].setBounds(i*60,100+j*60,60,60);
            content.add(myMap[i*5+j-5]);
        }
    }
    public void makeButtons2(JPanel content){
        for(int i=1;i<=5;i++)
            for(int j=1;j<=5;j++){
                enemyMap[i*5+j-5] = new JButton(new ImageIcon("water.png"));
                enemyMap[i*5+j-5].setBounds(i*60+400,100+j*60,60,60);
                enemyMap[i*5+j-5].setName(String.valueOf(i*5+j-5));
                content.add(enemyMap[i*5+j-5]);
                enemyMap[i*5+j-5].setVisible(false);
            }
    }
    void addAddBoatListener1(VapoareController.AddBoatListener cal)
    {
        for(int i=1;i<=25;i++)
            myMap[i].addActionListener(cal);

    }
    void addKillBoatListener(VapoareController.KillBoatListener cal)
    {
        for(int i=1;i<=25;i++)
            enemyMap[i].addActionListener(cal);
    }
    public JButton[] getEnemyMap() {
        return enemyMap;
    }
    public void showWinner(boolean w) {
        vaporLabel.setVisible(true);
        plsBoats.setVisible(false);
        for(int i=1;i<=25;i++) {
            myMap[i].setVisible(false);
            enemyMap[i].setVisible(false);
        }
        if(w == true)
            aiCastigat.setVisible(true);
        else aiPierdut.setVisible(true);

    }
}
