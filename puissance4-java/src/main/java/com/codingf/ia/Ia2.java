package com.codingf.ia;

import java.util.Random;


public class Ia2 {

    public static int ia2(char[][] grille) {
        Random tempo = new Random();
        int colonne = tempo.nextInt(7) + 1;
        if (colonne == 8) {
            colonne++;
        }
        while (estColonnePleine(colonne, grille)) {
            colonne = tempo.nextInt(7) + 1;
            if (colonne == 8) {
                colonne++;
            }
        }
        System.out.println(colonne);
        return colonne;
    }

    private static boolean estColonnePleine(int colonne, char[][] grid) {
        for (int i = 0; i < 6; i++) {
            if (grid[i][colonne - 1] != '@' && grid[i][colonne - 1] != '=') {
                return false;
            }
        }
        return true;
    }



    static boolean Fuite = false;
    // CONDITIONS DE VICTOIRE IA 2
/*
    public static boolean winConditionVerticaleIa2(char[][] grid) {
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][j] == '@' && grid[i + 1][j] == '@' && grid[i + 2][j] == '@') {
                    System.out.println("Possibilité de victoire en" + grid[i + 3][j]);
                    return ;
                }
                if (grid[i][j] == '=' && grid[i + 1][j] == '=' && grid[i + 2][j] == '=') {
                    System.out.println("Possibilité de victoire en" + grid[i + 3][j]);
                    return ;
                }
            }
        }


    /*
    public static boolean winConditionHorizontaleIa2(char[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == '@' && grid[i][j + 1] == '@' && grid[i][j + 2] == '@') {
                    System.out.println("Possibilité de victoire en" + grid[i + 3][j]);
                }
                if (grid[i][j] == '=' && grid[i][j + 1] == '=' && grid[i][j + 2] == '=') {
                    System.out.println("Possibilité de victoire en" + grid[i + 3][j]);

                }
            }
        }
    }
    public static boolean winConditionDABDIa2(char[][] grid) {


    }

    public static boolean winConditionDXBDIa2(char[][] grid) {

    }

    public static boolean winConditionDABGIa2(char[][] grid) {

    }

    public static boolean winConditionDXBGIa2(char[][] grid) {

    }

    public static boolean winConditionDAHDIa2(char[][] grid) {

    }

    public static boolean winConditionDAHGIa2(char[][] grid) {

    }

    public static boolean winConditionDXHGIa2(char[][] grid) {

    }

*/}