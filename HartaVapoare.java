package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class HartaVapoare{
    private ArrayList<Integer> array = new ArrayList<>();
    private int stillAlive;
    private int nrVapoare;

    public HartaVapoare(int stillAlive, ArrayList<Integer> array,int nrVapoare) {
        //super(array);
        this.array = array;
        this.stillAlive = stillAlive;
        this.nrVapoare = nrVapoare;
    }


    public void initHarta()
    {
        for(int i=0;i<=25;i++)
            array.add(-1);
    }
    public void showVapoare()
    {
        for(int i=1;i<=25;i++) {
            System.out.println(i+ " " + array.get(i) + " ");
        }
        }
    }
