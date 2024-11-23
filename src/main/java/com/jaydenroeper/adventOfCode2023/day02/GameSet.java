package com.jaydenroeper.adventOfCode2023.day02;

public class GameSet {
    private CubeHolder cubes;

    public GameSet() {

    }

    public GameSet(CubeHolder cubes) {
        this.cubes = cubes;
    }

    public CubeHolder getCubes() {
        return cubes;
    }

    public void setCubes(CubeHolder cubes) {
        this.cubes = cubes;
    }

    @Override
    public String toString() {
        return "GameSet{" +
                "cubes=" + cubes +
                '}';
    }
}
