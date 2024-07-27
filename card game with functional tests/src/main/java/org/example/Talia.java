package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class Talia {
    protected ArrayList<Karta> karty;

    public Talia() {
        karty = new ArrayList<>();
        for (Karta.Kolor kolor : Karta.Kolor.values()) {
            for (Karta.Typ typ : Karta.Typ.values()) {
                karty.add(new Karta(typ, kolor));
            }
        }
    }

    public static Talia stworzNowaTalia() {
        Talia t = new Talia();
        t.potasuj();
        return t;
    }

    public void potasuj() {
        Collections.shuffle(karty, new Random());
    }

    public Karta pociagnijKarte() throws BrakKartException {
        if (karty.isEmpty()) {
            throw new BrakKartException("Brak kart w talii!");
        }
        return karty.remove(0);
    }
}