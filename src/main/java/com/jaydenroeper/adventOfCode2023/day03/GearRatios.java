package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class GearRatios {
    private String [][] gearMatrix;

    private String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,";

    public GearRatios() {

    }

    public GearRatios(String fileName) {
        loadEngineSchematic(fileName);
    }

    public void loadEngineSchematic(String fileName) {
        String engineString = FileUtils.readFileToString(fileName);
        String[] lines = engineString.trim().split("\n");
        int width = lines[0].trim().split("").length;
        int height = lines.length;

        gearMatrix = new String [width][height];

        int x = 0;
        int y = 0;
        for (String line : lines) {
            for (String c : line.trim().split("")) {
//                System.out.println("X: " + x + " Y: " + y);
                gearMatrix[y][x] = c.trim();
                x++;
            }
            x = 0;
            y++;
        }
    }

    public int getSumOfPartNumbers() {
        int sum = 0;

        List<String> numbers = new ArrayList<>();
        List<String> adjacentNumbers = new ArrayList<>();

        for (int i = 0; i < gearMatrix.length; i++) {
            StringBuilder number = new StringBuilder();
            boolean isAdjacent = false;
            boolean wasNumber = false;

            for (int j = 0; j < gearMatrix[i].length; j++) {
                String s = gearMatrix[i][j];
                char c = s.charAt(0);
//                System.out.println(c + " digit:");
                if (Character.isDigit(c)) {
                    number.append(s);
//                    System.out.println("digit: " + c);
                    isAdjacent = isAdjacentToSymbol(s, i, j);
                    if (isAdjacent) {
                        System.out.println("isAdjacent: " + number);
                    }

                    wasNumber = true;
                } else {
                    if (wasNumber) {
                        if (isAdjacent) {
                            adjacentNumbers.add(number.toString());
                        }
                        numbers.add(number.toString());
                        number = new StringBuilder();
                    }

                    wasNumber = false;
                    isAdjacent = false;
                }
            }
        }

        System.out.println(numbers);
        System.out.println(adjacentNumbers);

        return sum;
    }

    private boolean isAdjacentToSymbol(String digit, int row, int col) {
        System.out.println("Checking if adjacent: " + digit + " " + row + " " + col);

        boolean isXSide = (col == 0 || col == gearMatrix[0].length - 1);
        boolean isYSide = (row == 0 || row == gearMatrix.length - 1);
//        System.out.println("IsXSide: " + isXSide + " IsYSide: " + isYSide);

        StringBuilder adjacentChars = new StringBuilder();


        try {
            String charTopLeft = gearMatrix[row - 1][col - 1];
            adjacentChars.append(charTopLeft);
        } catch (Exception _) {
        }
        try {
            String charTop = gearMatrix[row - 1][col];
            adjacentChars.append(charTop);
        } catch (Exception _) {
        }
        try {
            String charTopRight = gearMatrix[row - 1][col + 1];
            adjacentChars.append(charTopRight);
        } catch (Exception _) {
        }

        try {
            String charLeft = gearMatrix[row][col - 1];
            adjacentChars.append(charLeft);
        } catch (Exception _) {
        }
        try {
            String charRight = gearMatrix[row][col + 1];
            adjacentChars.append(charRight);
        } catch (Exception _) {
        }

        try {
            String charBottomLeft = gearMatrix[row + 1][col - 1];
            adjacentChars.append(charBottomLeft);
        } catch (Exception _) {
        }
        try {
            String charBottom = gearMatrix[row + 1][col];
            adjacentChars.append(charBottom);
        } catch (Exception _) {
        }
        try {
            String charBottomRight = gearMatrix[row + 1][col + 1];
            adjacentChars.append(charBottomRight);
        } catch (Exception _) {
        }

        System.out.println(adjacentChars);

        for (String ac : adjacentChars.toString().split("")) {
            if (specialChars.contains(ac)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        GearRatios g = new GearRatios("day03/example.txt");
        int partsSum = g.getSumOfPartNumbers();

        System.out.println("Sum of part numbers: " + partsSum);
    }
}
