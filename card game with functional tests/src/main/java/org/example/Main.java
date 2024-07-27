package org.example;

import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        GraWojna gierka = new GraWojna();

        String wynikGry = gierka.graj();

        System.out.println(wynikGry);
    }
}