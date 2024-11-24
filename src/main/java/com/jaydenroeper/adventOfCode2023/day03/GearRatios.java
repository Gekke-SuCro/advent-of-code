package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.Arrays;

public class GearRatios {
    private static final String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,";

    private String [][] gearMatrix;

    public GearRatios() {

    }

    public GearRatios(String fileName) {
        loadEngineSchematic(fileName);
    }

    public void loadEngineSchematic(String engineSchematic) {
        String[] lines = engineSchematic.split("\n");
        gearMatrix = new String[lines.length][lines[0].trim().split("").length];

        int row = 0;
        for (String line : lines) {
            int col = 0;
            for (String character : line.trim().split("")) {
                gearMatrix[row][col] = character.trim();
                col++;
            }
            row++;
        }
    }


    public static void main(String[] args) {
        String engineSchematic = FileUtils.readFileToString("day03/example.txt");

        GearRatios gearRatios = new GearRatios(engineSchematic);

    }
}
