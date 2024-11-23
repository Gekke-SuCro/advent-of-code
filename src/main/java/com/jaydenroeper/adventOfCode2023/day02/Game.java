package com.jaydenroeper.adventOfCode2023.day02;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;

    private List<GameSet> gameSets = new ArrayList<>();


    public Game(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<GameSet> getGameSets() {
        return gameSets;
    }

    public void addGameSet(GameSet gameSet) {
        gameSets.add(gameSet);
    }

    public static Game gameStringToGame(String gameString) {
        gameString = gameString.trim();
        int gameId = Integer.parseInt(gameString.split(":")[0].split(" ")[1]);
        String gameSets = gameString.split(":")[1].trim();

        Game game = new Game(gameId);

        for (String gameSetString : gameSets.split("; ")) {
//            System.out.println(gameSetString);
            int redCubes = 0;
            int greenCubes = 0;
            int blueCubes = 0;

            for (String gameData : gameSetString.trim().split(",")) {
                gameData = gameData.trim();
                int amount = Integer.parseInt(gameData.split(" ")[0]);
                String colorName = gameData.split(" ")[1].trim();

                if (colorName.equals("red")) {
                    redCubes = amount;
                } else if (colorName.equals("green")) {
                    greenCubes = amount;
                } else if (colorName.equals("blue")) {
                    blueCubes = amount;
                }
            }
            GameSet gameSet = new GameSet(new CubeHolder(redCubes, greenCubes, blueCubes));
            game.addGameSet(gameSet);
        }
        return game;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameSets=" + gameSets +
                '}';
    }
}
