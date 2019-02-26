package com.company;
import java.util.List;
import java.util.LinkedList;

public class Tray {
    private int capacity;
    private List<Cupcake> tray;

    public Tray() {
        this.capacity = 10;
        this.tray = new LinkedList<Cupcake>();
    }

    
}
