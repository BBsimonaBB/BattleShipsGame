package com.company;

import java.util.ArrayList;

public class VapoareModel {
    static int InitValueVapoare = 0;
    static int InitValueAlive = 3;
    private ArrayList<Integer> array = new ArrayList<Integer>();
    private int stillAlive = InitValueAlive;
    private int nrVapoare = InitValueVapoare;
    private HartaVapoare hv = new HartaVapoare(stillAlive,array,nrVapoare);

    public int getNrVapoare() {
        return nrVapoare;
    }

    public void setNrVapoare(int nrVapoare) {
        this.nrVapoare = nrVapoare;
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public int getStillAlive() {
        return stillAlive;
    }

    public void setStillAlive(int stillAlive) {
        this.stillAlive = stillAlive;
    }

    public HartaVapoare getHv() {
        return hv;
    }

}
