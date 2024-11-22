package com.jaydenroeper.adventOfCode2023.day02;

public class Game extends CubeHolder {
    private final int id;

    public Game(int id, int redCubes, int greenCubes, int blueCubes) {
        super(redCubes, greenCubes, blueCubes);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Game toGame(int id, String sets) {
//        System.out.println(sets);
        int redCubes = 0;
        int greenCubes = 0;
        int blueCubes = 0;
        for (String set : sets.split(";")) {
            set = set.trim();
            for (String cubeData : set.split(",")) {
                cubeData = cubeData.trim();
                int amount = Integer.parseInt(cubeData.split(" ")[0]);
                String color = cubeData.split(" ")[1];

//                System.out.println(color + " : " + amount);

                if (color.equals("red")) {
                    if (amount > redCubes) {
                        redCubes = amount;
                    }
                } else if (color.equals("green")) {
                    if (amount > greenCubes) {
                        greenCubes = amount;
                    }
                } else if (color.equals("blue")) {
                    if (amount > blueCubes) {
                        blueCubes = amount;
                    }
                }
            }
        }

        if (redCubes == 0 || greenCubes == 0 || blueCubes == 0) {
            return null;
        }

        return new Game(id, redCubes, greenCubes, blueCubes);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                '}';
    }
}
