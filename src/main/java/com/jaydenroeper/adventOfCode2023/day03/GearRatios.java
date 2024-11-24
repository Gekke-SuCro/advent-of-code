package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GearRatios {
    private static final String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,";

    private String [][] gearMatrix;

    public GearRatios() {

    }

    public GearRatios(String fileName) {
        loadEngineSchematic(fileName);
    }

    public int getSumOfPartNumbers() {
        int sum = 0;
        List<String> adjacentPartNumbers = findAdjacentPartNumbers();
        for (String partNumber : adjacentPartNumbers) {
            sum += Integer.parseInt(partNumber);
        }

        System.out.println(adjacentPartNumbers);

        return sum;
    }

    private List<String> findAdjacentPartNumbers() {
        List<String> adjacentPartNumbers = new ArrayList<>();

        for (int i = 0; i < gearMatrix.length; i++) {
            StringBuilder number = new StringBuilder();
            boolean wasDigit = false;
            boolean isAdjacent = false;

            for (int j = 0; j < gearMatrix[i].length; j++) {
                String part = gearMatrix[i][j];
                boolean isDigit = Character.isDigit(part.charAt(0));
                if (!isAdjacent) {
                    isAdjacent = isAdjacent(part, i, j);
                }

                if (isDigit) {
                    number.append(part);
                    wasDigit = true;
                } else {
                    if (wasDigit && isAdjacent) {
                        adjacentPartNumbers.add(number.toString());
                        number = new StringBuilder();
                    }
                    wasDigit = false;
                }
            }
        }

        return adjacentPartNumbers;
    }

    private boolean isAdjacent(String digit, int row, int col) {
        return true;
    }

    private void loadEngineSchematic(String engineSchematic) {
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
        int sum = gearRatios.getSumOfPartNumbers();

        System.out.println("Sum of Part Numbers: " + sum);
    }
}
