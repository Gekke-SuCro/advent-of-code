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
        String inputFileString = FileUtils.readFileToString(inputFile);

//        Load games from input file to a list of games
        for (String game : inputFileString.split("\n")) {
            readGame(game.trim());
        }

        int sumGameIds = 0;
        List<Game> possibleGames = new ArrayList<>();


        for (Game game : games) {
            if (game.getRedCubes() > bag.getRedCubes() ||
                    game.getGreenCubes() > bag.getGreenCubes() ||
                    game.getBlueCubes() > bag.getBlueCubes()) {
                continue;
            }

            possibleGames.add(game);
            sumGameIds += game.getId();
        }

        System.out.println(possibleGames);

        return sumGameIds;
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
//        int possibleGames = cubeConundrum.determinePossibleGames("day02/input.txt");
        System.out.println("Sum ids: " + possibleGames);

    }
}
