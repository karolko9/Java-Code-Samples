package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraTest {
    private Gra gra;

    @Before
    public void setUp() {
        gra = new Gra();
    }

    @Test
    public void testKonstruktor() {
        assertEquals(0, gra.gracze.size());
    }
}
