package com.example.adventofcode.trebuchet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trebuchet {
    private final String fileName;

    public Trebuchet(String fileName) {
        this.fileName = fileName;
    }

    public int calibrate() {
        int calibrationValue = 0;

        String fileLocation = "src/main/java/com/example/adventofcode/trebuchet/";
        try (BufferedReader br = new BufferedReader(new FileReader(fileLocation + fileName)))  {
            String line;
            while ((line = br.readLine()) != null) {
                calibrationValue += calibrateTwoDigitNumber(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + "at" + fileLocation + ": " + e.getMessage());
        }

        return calibrationValue;
    }

    private int calibrateTwoDigitNumber(String text) {
        List<Integer> digits = findDigitsInString(text);
        return digits.isEmpty() ? 0 : findTwoDigitNumber(digits);
    }

    private List<Integer> findDigitsInString(String text) {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            for (StringNumber sn : StringNumber.values()) {
                if (text.substring(i).startsWith(sn.name().toLowerCase())) {
                    digits.add(sn.value);
                    break;
                }
            }

            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                digits.add(Integer.valueOf(String.valueOf(c)));
            }
        }

        return digits;
    }

    private int findTwoDigitNumber(List<Integer> digits) {
        if (digits.size() < 2) {
            return parseDigit(digits, 0);
        }
        return parseDigit(digits, digits.size() - 1);
    }

    private int parseDigit(List<Integer> stringList, int index2) {
        return Integer.parseInt(stringList.getFirst() + String.valueOf(stringList.get(index2)));
    }

    public static void main(String[] args) {
        Trebuchet trebuchet = new Trebuchet("example2.txt");
        int calibrationSum = trebuchet.calibrate();

        System.out.println("Calibration sum: " + calibrationSum);
    }
}
