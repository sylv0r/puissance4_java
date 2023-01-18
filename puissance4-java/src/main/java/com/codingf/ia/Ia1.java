package com.codingf.ia;

import java.util.Random;


public class Ia1 {

    public static int ia1(char[][] grille) {
        Random tempo = new Random();
        int colonne = tempo.nextInt(6)+1;
        if(colonne == 6){
            colonne++;
        }
        while (estColonnePleine(colonne, grille)) {
            colonne = tempo.nextInt(6) + 1;
            if (colonne == 6) {
                colonne++;
            }
        }
        System.out.println(colonne);
        return colonne;
    }

    private static boolean estColonnePleine(int colonne, char[][] grid ) {
        for(int i = 0; i < 6; i++) {
            if (grid[i][colonne - 1] != '@' && grid[i][colonne - 1] != '=') {
                return false;
            }
        }
        return true;
    }

}