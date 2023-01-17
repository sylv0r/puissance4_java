package com.codingf.menu;
import com.codingf.game.Game;
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
            System.out.println("3. Le top 10");
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

                    game.start();
                    break;
                case 3:
                    System.out.println("Vous avez choisi l'option 3.");
                    Top10.top10();
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