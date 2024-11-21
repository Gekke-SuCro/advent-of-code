package com.example.adventofcode.trebuchet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trebuchet {
    private String fileName;

    public Trebuchet(String fileName) {
        this.fileName = fileName;
    }

    public int calibrate() {
        int calibrationValue = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))  {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> digits = findDigits(line);
                if (!digits.isEmpty()) {
                    calibrationValue += findTwoDigitNumber(digits);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + ": " + e.getMessage());
        }

        return calibrationValue;
    }

    private List<String> findDigits(String text) {
        List<String> digits = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                digits.add(String.valueOf(c));
            }
        }

        return digits;
    }

    private int findTwoDigitNumber(List<String> digits) {
        System.out.println(digits);
        if (digits.size() < 2) {
            return parseDigit(digits, 0, 0);
        }
        return parseDigit(digits, 0, digits.size() - 1);
    }

    private int parseDigit(List<String> stringListt, int index1, int index2) {
        return Integer.parseInt(stringListt.get(index1) + stringListt.get(index2));
    }

    public static void main(String[] args) {
        Trebuchet trebuchet = new Trebuchet("input.txt");
        int calibrationSum = trebuchet.calibrate();

        System.out.println(calibrationSum);
    }
}
