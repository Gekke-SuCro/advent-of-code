package com.jaydenroeper.adventOfCode2023.day02;


import com.jaydenroeper.adventOfCode2023.utils.FileUtils;


public class CubeConundrum {
    private final CubeHolder bag;

    public CubeConundrum(CubeHolder bag) {
        this.bag = bag;
    }

    public int determine(String inputFile) {
        int possibleGameIds = 0;

        String inputFileString = FileUtils.readFileToString(inputFile);
        for (String gameString : inputFileString.trim().split("\n")) {
            possibleGameIds += calculate(gameString);
        }

        return possibleGameIds;
    }

    private int calculate(String gameString) {
        gameString = gameString.trim();
        int gameId = Integer.parseInt(gameString.split(":")[0].split(" ")[1]);
        String gameSets = gameString.split(":")[1].trim();

        for (String gameSet : gameSets.split("; ")) {
            for (String gameData : gameSet.trim().split(",")) {
                gameData = gameData.trim();
                int amount = Integer.parseInt(gameData.split(" ")[0]);
                String colorName = gameData.split(" ")[1].trim();

                if ((colorName.equals("red") && amount > bag.redCubes()) ||
                        (colorName.equals("blue") && amount > bag.blueCubes()) ||
                        (colorName.equals("green") && amount > bag.greenCubes())) {
                    return 0;
                }
            }
        }
        return gameId;
    }

    public static void main(String[] args) {
        CubeConundrum cubeConundrum = new CubeConundrum(
                new CubeHolder(12, 13, 14)
        );

        int possibleGames = cubeConundrum.determine("day02/input.txt");
        System.out.println("Possible gameIds sum: " + possibleGames);
    }
}
