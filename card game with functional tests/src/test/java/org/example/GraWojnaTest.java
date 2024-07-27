package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraWojnaTest {

    private GraWojna graWojna;

    @Before
    public void setUp() throws Exception {
        graWojna = new GraWojna();
    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void testKonstruktorGraWojna() {
        assertEquals(2, graWojna.gracze.size());
    }

    @Test
    public void rozdajKarty() {
        assertEquals(26, graWojna.gracze.get(0).reka.size());
        assertEquals(26, graWojna.gracze.get(1).reka.size());
    }

    @Test
    public void przeniesKarty() {
        Gracz gracz1 = graWojna.gracze.get(0);
        Gracz gracz2 = graWojna.gracze.get(1);

        gracz1.reka.clear();
        graWojna.przeniesKarty(gracz2, gracz1);

        assertEquals(0, gracz2.reka.size());

        assertEquals(26, gracz1.reka.size());
    }

    @Test
    public void graj() {
        String wynik = graWojna.graj();
        assertTrue(wynik.equals("remis") || wynik.equals("gracz 1 wygrywa") || wynik.equals("gracz 2 wygrywa"));
        assertTrue(graWojna.gracze.get(0).reka.isEmpty() ||graWojna.gracze.get(1).reka.isEmpty());
    }
}