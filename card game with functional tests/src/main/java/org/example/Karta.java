package org.example;

import java.util.Objects;

public class Karta {

    public enum Kolor {
        Trefl, Karo, Kier, Pik;
    }


    public enum Typ {
        DWA, TRZY, CZTERY, PIEC, SZESC, SIEDM, OSIEM, DZIEWIEC, DZIESIEC, WALET, DAMA, KROL, AS;
    }


    Kolor kolor;


    Typ typ;


    public Karta(Typ a, Kolor b) {
        this.kolor = b;
        this.typ = a;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta card = (Karta) o;
        return kolor == card.kolor && typ.equals(card.typ);
    }


    @Override
    public int hashCode() {
        return Objects.hash(kolor, typ);
    }
}
