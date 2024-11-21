package com.example.adventofcode;

import java.io.*;

public class Trebuchet {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/java/com/example/adventofcode/input.txt");

        BufferedReader bf = new BufferedReader(new FileReader(inputFile));

        String line;
        while ((line = bf.readLine()) != null) {
           System.out.println(line);
        }
    }
}
