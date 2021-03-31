package com.codecool.ants.colony;

import com.codecool.ants.colony.ants.*;

import java.util.ArrayList;
import java.util.List;

public class Colony {
    private final int width;
    private final Queen queen;
    private final List<Ant> ants;

    public Colony(int width) {
        this.width = width;
        this.queen = new Queen(width / 2, width / 2);
        this.ants = new ArrayList<>();
    }

    public void generateAnts(int numberOfDrone, int numberOfWorker, int numberOfSoldier) {
        this.ants.addAll(generateAnt(numberOfDrone, 'D'));
        this.ants.addAll(generateAnt(numberOfWorker, 'W'));
        this.ants.addAll(generateAnt(numberOfSoldier, 'S'));
    }

    private List<Ant> generateAnt(int number, char type) {
        List<Ant> ants = new ArrayList<>();

        for(int i = 0; i < number; i++) {
            switch (type) {
                case 'D':
                    ants.add(new Drone(this.width));
                    break;
                case 'W':
                    ants.add(new Worker(this.width));
                    break;
                case 'S':
                    ants.add(new Soldier(this.width));
                    break;
            }
        }

        return ants;
    }

    public void update() {
        queen.move();
        for (Ant ant : ants) {
            ant.move();
        }
    }

    private String getAntTypeAtPosition(int x, int y) {
        if (this.queen.getX() == x && this.queen.getY() == y) {
            return "Q";
        } else {
            for (Ant ant : ants) {
                if (ant.getX() == x && ant.getY() == y) {
                    if (ant instanceof Soldier) {
                        return "S";
                    } else if (ant instanceof Drone) {
                        return "D";
                    } else {
                        return "W";
                    }
                }
            }
        }
        return ".";
    }

    public void startFuckIfPossible() {
        for (Ant ant : this.ants) {
            if (ant instanceof Drone && ((Drone)ant).isQueenReached()) {
                if (queen.isReadyToFuck()) {
                    ((Drone) ant).setFucking(true);
                    queen.resetMood();
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(getAntTypeAtPosition(j, i));
            }
            System.out.println();
        }
        System.out.println("Quen ready to fuck: " + queen.isReadyToFuck());
        for (Ant ant : ants) {
            if (ant instanceof Drone) {
                System.out.println("is queen reached: " + ((Drone)ant).isQueenReached());
                System.out.println("is fucking: " + ((Drone)ant).isFucking());
            }
        }

    }
}
