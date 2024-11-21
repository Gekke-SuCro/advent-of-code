package com.example.adventofcode.trebuchet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrebuchetTest {
    private final String fileLocation = "src/test/java/com/example/adventofcode/trebuchet/";

    @Test
    public void testTrebuchet() {
        Trebuchet trebuchet = new Trebuchet(fileLocation + "test.txt");
        int calibrationSum = trebuchet.calibrate();

        assertEquals(122, calibrationSum);
    }

    @Test
    public void testTrebuchetExample() {
        Trebuchet trebuchet = new Trebuchet(fileLocation + "example.txt");
        int calibrationSum = trebuchet.calibrate();

        assertEquals(142, calibrationSum);
    }
}
