package com.jaydenroeper.advent.year2023.day01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrebuchetTest {
    private final String fileLocation = "src/test/java/com/example/adventofcode/trebuchet/";

    @Test
    public void testTrebuchet() {
        int calibrationSum = Trebuchet.calibrate(fileLocation + "test.txt");

        assertEquals(122, calibrationSum);
    }

    @Test
    public void testTrebuchetExample() {
        int calibrationSum = Trebuchet.calibrate(fileLocation + "example.txt");

        assertEquals(142, calibrationSum);
    }

    @Test
    public void testTrebuchetExample2() {
        int calibrationSum = Trebuchet.calibrate(fileLocation + "example2.txt");

        assertEquals(281, calibrationSum);
    }
}
