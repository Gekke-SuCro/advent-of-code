package com.jaydenroeper.adventOfCode2023.day02;

public record GameSet(CubeHolder cubes) {

    @Override
    public String toString() {
        return "GameSet{" +
                "cubes=" + cubes +
                '}';
    }
}
