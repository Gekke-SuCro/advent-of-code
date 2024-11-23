package com.jaydenroeper.adventOfCode2023.day03;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

public class GearRatios {

    public GearRatios() {

    }

    public static void main(String[] args) {
        GearRatios g = new GearRatios();

        String engineString = FileUtils.readFileToString("day03/example.txt");

        for (String text : engineString.split("\n")) {
            System.out.println(text);
        }
    }
}
