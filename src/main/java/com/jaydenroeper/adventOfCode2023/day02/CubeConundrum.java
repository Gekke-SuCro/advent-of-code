package com.jaydenroeper.adventOfCode2023.day02;

import com.jaydenroeper.adventOfCode2023.utils.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeConundrum {
    private final CubeHolder bag;
    private List<Game> games;

    public CubeConundrum(CubeHolder bag) {
        this.bag = bag;
        games = new ArrayList<>();
    }

    public int determinePossibleGames(String inputFile) {
        int possibleGames = 0;

        String inputFileString = FileUtils.readFileToString(inputFile);

//        Load games from input file to a list of games
        for (String game : inputFileString.split("\n")) {
            readGame(game.trim());
        }

        for (Game game : games) {
            System.out.println("Game: " + game);
        }

        return possibleGames;
    }

    private void readGame(String gameString) {
        int id = Integer.parseInt(gameString.split(":")[0].split(" ")[1]);
        String sets = gameString.split(":")[1];

        Game game = Game.toGame(id, sets);
        if (game != null) {
            games.add(game);
        }
    }

    public static void main(String[] args) {
        CubeConundrum cubeConundrum = new CubeConundrum(
                new CubeHolder(12, 14, 14)
        );

        int possibleGames = cubeConundrum.determinePossibleGames("day02/example.txt");
        System.out.println("Possible games: " + possibleGames);

    }
}
