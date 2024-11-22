package com.jaydenroeper.adventOfCode2023.day01;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trebuchet {

    public Trebuchet(String fileName) {
    }

    public static int calibrate(String filePath) {
        int calibrationValue = 0;

//        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))  {
//            String line;
//            while ((line = br.readLine()) != null) {
//                calibrationValue += calibrateTwoDigitNumber(line);
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }

        return calibrationValue;
    }

    private static int calibrateTwoDigitNumber(String text) {
        List<Integer> digits = findDigitsInString(text);
        return digits.isEmpty() ? 0 : findTwoDigitNumber(digits);
    }

    private static List<Integer> findDigitsInString(String text) {
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

    private static int findTwoDigitNumber(List<Integer> digits) {
        if (digits.size() < 2) {
            return parseDigit(digits, 0);
        }
        return parseDigit(digits, digits.size() - 1);
    }

    private static int parseDigit(List<Integer> stringList, int index2) {
        return Integer.parseInt(stringList.getFirst() + String.valueOf(stringList.get(index2)));
    }

    public static void main(String[] args) {
        int calibrationSum = Trebuchet.calibrate("day01/input.txt");

        System.out.println("Calibration sum: " + calibrationSum);
    }
}
