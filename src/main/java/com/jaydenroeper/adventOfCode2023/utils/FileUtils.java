package com.jaydenroeper.adventOfCode2023.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    public static String readFileToString(String filePath) {
        StringBuilder fileSb = new StringBuilder();

        try (InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath)) {
            assert inputStream != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    fileSb.append(line).append(System.lineSeparator());
                }

                return fileSb.toString();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load file: " + filePath, e);
        }
    }

    public static void main(String[] args) {
        System.out.println(readFileToString("day01/input.txt"));
    }
}
