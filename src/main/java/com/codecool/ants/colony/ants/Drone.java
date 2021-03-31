package com.codecool.ants.colony.ants;

import java.util.Random;

public class Drone extends Ant {
    private boolean isFucking;
    private int fuckingCounter;

    public Drone(int width) {
        super(width);
        this.isFucking = false;
        this.fuckingCounter = 0;
    }


    @Override
    public void move() {
        if (isFucking) {
            this.fuckingCounter++;
            if (fuckingCounter == 10) {
                this.isFucking = false;
                this.fuckingCounter = 0;
                generateNewPositionOnMeetingQueen();
            }
        } else {
            if (isQueenReached()) {
                generateNewPositionOnMeetingQueen();
            } else {
                int x = this.x - width / 2;
                int y = this.y - width / 2;
                if (Math.abs(x) > Math.abs(y)) {
                    if (x < 0) {
                        this.x++;
                    } else {
                        this.x--;
                    }
                } else {
                    if (y < 0) {
                        this.y++;
                    } else {
                        this.y--;
                    }
                }
            }
        }
    }



    public boolean isQueenReached() {
        int center = width / 2;
        return this.x == center && this.y == center;
    }

    public void generateNewPositionOnMeetingQueen() {
        int direction = new Random().nextInt(4);

        switch (direction) {
            case 0:
                this.x = 0;
                this.y = new Random().nextInt(width);
                break;
            case 1:
                this.x = width - 1;
                this.y = new Random().nextInt(width);
                break;
            case 2:
                this.y = 0;
                this.x = new Random().nextInt(width);
                break;
            case 3:
                this.y = width - 1;
                this.x = new Random().nextInt(width);
                break;
        }
    }

    public boolean isFucking() {
        return isFucking;
    }

    public void setFucking(boolean fucking) {
        isFucking = fucking;
    }
}
