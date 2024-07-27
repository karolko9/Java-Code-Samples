package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraczTest {

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void pociagnij() {
        Gracz gracz = new Gracz();
        gracz.reka = Talia.stworzNowaTalia().karty;
        for (int i =0 ; i<52; i++){
            Karta karta1 = gracz.pociagnij(0);
            Karta karta2 = gracz.reka.get(0);
            assertEquals(karta1, karta2);
        }

    }
}