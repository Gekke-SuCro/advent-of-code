package com.jaydenroeper.adventOfCode2023.day02;

public class CubeHolder {
    private final int redCubes;
    private final int greenCubes;
    private final int blueCubes;

    public CubeHolder(int redCubes, int greenCubes, int blueCubes) {
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    public int getRedCubes() {
        return redCubes;
    }

    public int getGreenCubes() {
        return greenCubes;
    }

    public int getBlueCubes() {
        return blueCubes;
    }

    @Override
    public String toString() {
        return "CubeHolder{" +
                "redCubes=" + redCubes +
                ", greenCubes=" + greenCubes +
                ", blueCubes=" + blueCubes +
                '}';
    }
}
