package com.codingf.menu;
import com.codingf.game.Game;
import com.codingf.grid.Grid;
import com.codingf.player.Player;
import com.codingf.top10.Top10;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Jouer contre l'IA");
            System.out.println("2. Jouer à 2");
            System.out.println("3. Score ");
            System.out.println("4. Rejouer");
            System.out.println("5. QUITTER");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vous avez choisi l'option 1.");

                    menuia();
                    break;
                case 2:
                    System.out.println("Vous avez choisi l'option 2.");
                    Grid.resetTkt();
                    game.start();
                    break;
                case 3:


                    System.out.println("Vous avez choisi l'option 3.");

                    Top10.readTop10();
                    break;
                case 4:
                    System.out.println("Vous avez choisi l'option 4.");
                    game.restart();
                    break;
                case 5:
                    System.out.println("Vous avez choisi l'option 5.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Veuillez choisir un bon choix.");
            }
        } while (choice != 0);
    }
    public static void menuia() {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu IA:");
            System.out.println("1. Jouer contre l'IA Niveau 1");
            System.out.println("2. Jouer contre l'IA Niveau 2");
            System.out.println("3. Menu principale");
            System.out.println("4. QUITTER");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Vous avez choisi l'option 1.");
                    game.startIa1();
                    break;
                case 2:
                    System.out.println("Vous avez choisi l'option 2.");
                    game.startIa3();
                    break;
                case 3:
                    System.out.println("Vous avez choisi l'option 3.");
                    menu();
                    break;
                case 4:
                    System.out.println("Vous avez choisi l'option 4.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Veuillez choisir un bon choix.");
            }
        } while (choice != 0);
    }
}