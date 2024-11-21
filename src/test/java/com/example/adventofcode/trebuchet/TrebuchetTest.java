package com.example.adventofcode.trebuchet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrebuchetTest {
    @Test
    public void testTrebuchet() {
        Trebuchet trebuchet = new Trebuchet("test.txt");
        int calibrationSum = trebuchet.calibrate();

        assertEquals(122, calibrationSum);
    }

    @Test
    public void testTrebuchetExample() {
        Trebuchet trebuchet = new Trebuchet("example.txt");
        int calibrationSum = trebuchet.calibrate();

        assertEquals(142, calibrationSum);
    }
}
