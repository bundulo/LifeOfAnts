package com.codecool.ants.colony.ants;

import com.codecool.ants.geometry.Direction;

public class Soldier extends Ant {
    private Direction cycleStatus;

    public Soldier(int width) {
        super(width);
        this.cycleStatus = Direction.NORTH;
    }
    

    @Override
    public void move() {
        switch (cycleStatus) {
            case NORTH:
                if (y > 0) {
                    this.y--;
                }
                cycleStatus = Direction.EAST;
                break;
            case EAST:
                if (x < width-2) {
                    this.x++;
                }
                cycleStatus = Direction.SOUTH;
                break;
            case SOUTH:
                if (y < width-2) {
                    this.y++;
                }
                cycleStatus = Direction.WEST;
                break;
            case WEST:
                if (x > 0) {
                    this.x--;
                }
                cycleStatus = Direction.NORTH;
                break;
        }
    }
}
