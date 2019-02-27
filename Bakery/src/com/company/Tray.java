package com.company;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Tray {
    private int capacity;
    private List<Cupcake> tray;

    public Tray() {
        this.capacity = 10;
        this.tray = new LinkedList<>();
    }

    public Cupcake addOneCupcake(String cupcakeType) throws IllegalStateException{
        while(true){
            synchronized (tray){
                if(tray.size() >= this.capacity){
                    tray.wait();
                    continue;
                }
                Cupcake cupcake = new Cupcake(cupcakeType);
                tray.add(cupcake);
                System.out.println("Cupcake added " + cupcake);
                return cupcake;
            }
        }
        throw new IllegalStateException("Could not add cupcake to tray.");
    }

}
