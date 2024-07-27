package org.example;

import java.util.ArrayList;
import java.util.List;


public class Gracz {

    public ArrayList<Karta> reka;


    public Gracz() {
        this.reka = new ArrayList<>();
    }


    public Karta pociagnij(int i) {
        return reka.get(i);
    }
}
