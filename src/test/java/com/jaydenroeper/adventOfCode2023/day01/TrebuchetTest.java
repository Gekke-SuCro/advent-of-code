package com.jaydenroeper.adventOfCode2023.day01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrebuchetTest {
    @Test
    public void testTrebuchet() {
        int calibrationSum = Trebuchet.calibrate( "day01/test.txt");

        assertEquals(122, calibrationSum);
    }

    @Test
    public void testTrebuchetExample() {
        int calibrationSum = Trebuchet.calibrate("day01/example.txt");

        assertEquals(142, calibrationSum);
    }

    @Test
    public void testTrebuchetExample2() {
        int calibrationSum = Trebuchet.calibrate( "day01/example2.txt");

        assertEquals(281, calibrationSum);
    }
}
