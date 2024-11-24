package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GearRatios {
    private static String specialChars = "*-$%+&/@=#";

    private String [][] gearMatrix;

    public GearRatios() {

    }

    public GearRatios(String fileName) {
        loadEngineSchematic(fileName);
//        System.out.println(Arrays.deepToString(gearMatrix));
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
            boolean isAdjacent = false;

            for (int j = 0; j < gearMatrix[i].length; j++) {
                String part = gearMatrix[i][j];
                boolean isDigit = Character.isDigit(part.charAt(0));

                if (isDigit) {
                    if (isAdjacent(part, i, j)) {
                        isAdjacent = true;
                    }
                    number.append(part);
                } else {
                    if (isAdjacent) {
                        adjacentPartNumbers.add(number.toString());
                    }
                    number = new StringBuilder();
                    isAdjacent = false;
                }
            }
        }

        return adjacentPartNumbers;
    }

    public boolean isAdjacent(String digit, int row, int col) {
        List<String> adjacentChars = new ArrayList<>();

//        Row above
        try {
            String topLeft = gearMatrix[row - 1][col - 1];
            adjacentChars.add(topLeft);
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            String top = gearMatrix[row - 1][col];
            adjacentChars.add(top);
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            String topRight = gearMatrix[row - 1][col + 1];
            adjacentChars.add(topRight);
        } catch (ArrayIndexOutOfBoundsException _) {}

//        Same row
        try {
            String left = gearMatrix[row][col - 1];
            adjacentChars.add(left);
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            String right = gearMatrix[row][col + 1];
            adjacentChars.add(right);
        } catch (ArrayIndexOutOfBoundsException _) {}

//        Row below
        try {
            String bottomLeft = gearMatrix[row + 1][col - 1];
            adjacentChars.add(bottomLeft);
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            String bottom = gearMatrix[row + 1][col];
            adjacentChars.add(bottom);
        } catch (ArrayIndexOutOfBoundsException _) {}
        try {
            String bottomRight = gearMatrix[row + 1][col + 1];
            adjacentChars.add(bottomRight);
        } catch (ArrayIndexOutOfBoundsException _) {}

//        if (row == gearMatrix.length - 1 && col == gearMatrix[gearMatrix.length - 1].length - 1) {
//            System.out.println("Digit: " + digit + " Neighbours: " + adjacentChars);
//        }

        for (String c : adjacentChars) {
            boolean isSpecial = (!Character.isDigit(c.charAt(0)) && !c.equals("."));
//            System.out.println("Char: " + c + ", Row: " + row + ", Col: " + col + "isSpecial: " + isSpecial);
            if (isSpecial) {
                return true;
            }
        }

        return false;
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
