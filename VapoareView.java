package com.company;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;

public class VapoareView extends JFrame {
        private JTextArea m_welcome = new JTextArea("Welcome");;
        private JTextField m_name = new JTextField(5);
        private JButton m_gobtn = new JButton("GO!");
        private JButton m_startbtn = new JButton("Start");
        private VapoareModel m_model;
        String name;


        VapoareView(VapoareModel model)
        {
                m_model = model;
                Font  f2  = new Font(Font.SANS_SERIF,  Font.BOLD, 10);
                Font  f3  = new Font(Font.MONOSPACED, Font.ROMAN_BASELINE ,20) ;
                Color color_background = new Color(231,254,255);
                m_gobtn.setFont(f2);
                m_startbtn.setFont(f3);

                m_name.setBounds(20,200,120,20);
                m_gobtn.setBounds(140,200,60,20);
                m_startbtn.setBounds(500,450,100,40);

                ImageIcon vaporIcon = new ImageIcon("vapor.png");
                JLabel vaporLabel = new JLabel(vaporIcon);
                vaporLabel.setBounds(250,180,1100,500);



                ImageIcon welcomeIcon = new ImageIcon("battleship1.png");
                JLabel welcomeLabel = new JLabel(welcomeIcon);
                welcomeLabel.setBounds(400,10,350,116);

                ImageIcon rocketIcon = new ImageIcon("rocket.png");
                JLabel rocketLabel = new JLabel(rocketIcon);
                rocketLabel.setBounds(250,300,250,74);

                ImageIcon smokeIcon = new ImageIcon("smoke.png");
                JLabel smokeLabel = new JLabel(smokeIcon);
                smokeLabel.setBounds(170,310,100,56);

                JPanel content = new JPanel();
                content.setBackground(color_background);
                content.setLayout(null);


                JLabel plsName = new JLabel("Please enter your name...");
                plsName.setBounds(20,180,300,20);
                content.add(m_startbtn);
                content.add(plsName);
                content.add(m_gobtn);
                content.add(m_name);
                content.add(vaporLabel);
                content.add(rocketLabel);
                content.add(welcomeLabel);
                content.add(smokeLabel);


                this.setContentPane(content);
                this.pack();
                this.setTitle("Vapoare");
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(1200,700);
        }
        void setNamee(String newName) {
                m_name.setText("Good luck, " + newName);
                name = newName;
        }
        public JButton getM_gobtn() {
                return m_gobtn;
        }

        void addNameListener(ActionListener cal) {
                m_gobtn.addActionListener(cal);
        }
        void addOpenListener(ActionListener cal) {
                m_startbtn.addActionListener(cal);
        }
        String getM_name() {
                return m_name.getText();
        }
        public JTextField getM__name(){
                return m_name;
        }
}