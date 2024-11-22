package com.jaydenroeper.adventOfCode2023.day02;

public record CubeHolder(int redCubes, int greenCubes, int blueCubes) {

    @Override
    public String toString() {
        return "CubeHolder{" +
                "redCubes=" + redCubes +
                ", greenCubes=" + greenCubes +
                ", blueCubes=" + blueCubes +
                '}';
    }
}
