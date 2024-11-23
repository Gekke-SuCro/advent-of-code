package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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

                    wasNumber = true;
                } else {
                    if (wasNumber) {
                        if (isAdjacent) {
                            adjacentNumbers.add(number.toString());
                            isAdjacent = false;
                        }
                        numbers.add(number.toString());
                        number = new StringBuilder();
                    }

                    wasNumber = false;
                }
            }
        }

        System.out.println(numbers);
        System.out.println(adjacentNumbers);

        return sum;
    }

    private boolean isAdjacentToSymbol(String digit, int row, int col) {
        System.out.println("Checking if adjacent: " + digit + " " + row + " " + col);
        return false;
    }


    public static void main(String[] args) {
        GearRatios g = new GearRatios("day03/example.txt");
        int partsSum = g.getSumOfPartNumbers();

        System.out.println("Sum of part numbers: " + partsSum);
    }
}
