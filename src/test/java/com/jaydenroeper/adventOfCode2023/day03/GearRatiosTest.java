package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GearRatiosTest {

    @Test
    public void testExample() {
        String engineSchematic = FileUtils.readFileToString("day03/example.txt");
        GearRatios gearRatios = new GearRatios(engineSchematic);

        assertEquals(4361, gearRatios.getSumOfPartNumbers());
    }
}
