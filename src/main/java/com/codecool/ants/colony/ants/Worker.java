package com.codecool.ants.colony.ants;

import java.util.Random;

public class Worker extends Ant {
    public Worker(int width) {
        super(width);
    }

    @Override
    public void move() {
        int direction = new Random().nextInt(4);
        switch (direction) {
            case 0:
                if (x < width - 2) {
                    this.x++;
                }
                break;
            case 1:
                if (y < width - 2) {
                    this.y++;
                }
                break;
            case 2:
                if (x > 0) {
                    this.x--;
                }
                break;
            case 3:
                if (y > 0) {
                    this.y--;
                }
                break;
        }
    }
}
