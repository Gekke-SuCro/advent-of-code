package com.jaydenroeper.adventOfCode2023.day02;

public record GameSet(CubeHolder cubes) {

    public boolean isWithinCubeHolder(CubeHolder cubeHolder) {
        return (cubes.redCubes() <= cubeHolder.redCubes()) &&
                (cubes.greenCubes() <= cubeHolder.greenCubes()) &&
                (cubes.blueCubes() <= cubeHolder.blueCubes());
    }

    @Override
    public String toString() {
        return "GameSet{" +
                "cubes=" + cubes +
                '}';
    }
}
