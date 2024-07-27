package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class TaliaTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void stworzNowaTalia() {
        Talia talia = Talia.stworzNowaTalia();
        assertEquals(talia.karty.size(), 52);
        HashSet<Karta> karty1 = new HashSet<>();
        for (int i = 0 ; i<52; i++){
            karty1.add(talia.karty.get(i));
        }
        assertEquals(karty1.size(), 52);
    }

    @Test
    public void potasuj() {
        Talia talia = Talia.stworzNowaTalia();
        ArrayList<Karta> stanPrzedPotasowaniem = new ArrayList<>(talia.karty);
        talia.potasuj();
        assertNotEquals(stanPrzedPotasowaniem, talia.karty);
    }

    @Test
    public void testPociagnijKarte() throws BrakKartException {
        Talia talia = Talia.stworzNowaTalia();
        Karta karta = talia.pociagnijKarte();
        assertNotNull(karta);
    }

    @Test(expected = BrakKartException.class)
    public void testPociagnijKarteZBrakuKart() throws BrakKartException {
        Talia talia = Talia.stworzNowaTalia();
        while (!talia.karty.isEmpty()) {
            talia.pociagnijKarte();
        }
        talia.pociagnijKarte();
    }
}