package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KartaTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void testEquals() {
        Karta karta1 = new Karta(Karta.Typ.AS, Karta.Kolor.Pik);
        Karta karta2 = new Karta(Karta.Typ.AS, Karta.Kolor.Pik);
        Karta karta3 = new Karta(Karta.Typ.WALET, Karta.Kolor.Trefl);

        assertTrue(karta1.equals(karta2));

        assertFalse(karta1.equals(karta3));
    }

    @Test
    public void testHashCode() {
        Karta karta1 = new Karta(Karta.Typ.AS, Karta.Kolor.Pik);
        Karta karta2 = new Karta(Karta.Typ.AS, Karta.Kolor.Pik);
        Karta karta3 = new Karta(Karta.Typ.WALET, Karta.Kolor.Trefl);

        assertEquals(karta1.hashCode(), karta2.hashCode());

        assertNotEquals(karta1.hashCode(), karta3.hashCode());
    }
}

//        Talia t1 = new Talia();
//        t1 = Talia.stworzNowaTalia();
//        t1.potasuj();
//        HashSet<Karta> proba = new HashSet<>();
//        proba.addAll(t1.karty);
//        proba.addAll(t1.karty);
//        int sets = proba.size();
//        System.out.println("Rozmiar zbioru: " + sets);