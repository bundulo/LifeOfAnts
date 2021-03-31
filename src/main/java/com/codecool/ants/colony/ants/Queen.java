package com.codecool.ants.colony.ants;


import java.util.Random;

public class Queen extends Ant {
    private int mood;

    public Queen(int x, int y) {
        super(x, y);
        resetMood();
    }

    @Override
    public void move() {
        this.mood--;
    }

    public boolean isReadyToFuck() {
        return mood == 0;
    }

    public void resetMood() {
        this.mood = new Random().nextInt(51) + 50;
    }
}
