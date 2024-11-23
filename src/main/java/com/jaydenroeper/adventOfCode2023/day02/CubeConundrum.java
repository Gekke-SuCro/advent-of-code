package com.jaydenroeper.adventOfCode2023.day02;


import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;


public class CubeConundrum {
    private final CubeHolder bag;
    private List<Game> games;

    public CubeConundrum(CubeHolder bag, String inputFile) {
        this.bag = bag;
        loadInputFile(inputFile);
    }

    public List<Game> getGames() {
        return games;
    }

    public void loadInputFile(String inputFile) {
        games = new ArrayList<>();

        String inputFileString = FileUtils.readFileToString(inputFile);
        for (String gameString : inputFileString.trim().split("\n")) {
            Game game = Game.gameStringToGame(gameString);
            games.add(game);
        }
    }

    public int determinePossibleGameIds() {
        int gameIdsSum = 0;
        List<Game> possibleGames = findGamesPossible();

        for (Game game : possibleGames) {
            gameIdsSum += game.getId();
        }

        return gameIdsSum;
    }

    private List<Game> findGamesPossible() {
        List<Game> possibleGames = new ArrayList<>();

        for (Game game : games) {
            boolean possibleGameFound = true;
            for (GameSet gameSet : game.getGameSets()) {
                if (!gameSet.isWithinCubeHolder(bag)) {
                    possibleGameFound = false;
                    break;
                }
            }

            if (possibleGameFound) {
                possibleGames.add(game);
            }
        }

        return possibleGames;
    }

    public static void main(String[] args) {
        CubeConundrum cubeConundrum = new CubeConundrum(
                new CubeHolder(12, 13, 14),
                "day02/input.txt"
        );

        List<Game> games = cubeConundrum.getGames();
        System.out.println(games);
//
        int possibleGames = cubeConundrum.determinePossibleGameIds();
        System.out.println("Possible gameIds sum: " + possibleGames);
    }
}
