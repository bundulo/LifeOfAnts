package com.codecool.ants;

import com.codecool.ants.colony.Colony;

import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        System.out.println("give me the size of the colony");
        int width = new Scanner(System.in).nextInt();
        System.out.println("give me the number of drones");
        int drone = new Scanner(System.in).nextInt();
        System.out.println("give me the number of workers");
        int worker = new Scanner(System.in).nextInt();
        System.out.println("give me the number of soldiers");
        int soldier = new Scanner(System.in).nextInt();
        Colony tetvek = new Colony(width);
        tetvek.generateAnts(drone, worker, soldier);

        while(true) {
            tetvek.update();
            tetvek.startFuckIfPossible();
            tetvek.display();
            System.out.println("Please press enter to update colony");
            String line = new Scanner(System.in).nextLine();
            if (line.equals("q")) {
                break;
            }
        }
    }
}
