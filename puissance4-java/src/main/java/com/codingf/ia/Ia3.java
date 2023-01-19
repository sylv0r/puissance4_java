package com.codingf.ia;

import com.codingf.player.Player;

import java.util.Random;


public class Ia3 {

    public static int ia3(char[][] grid, Player currentPlayer) {
        // On commence par vérifier si le joueur adverse peut gagner en plaçant un jeton
        // dans une colonne donnée


        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                if (grid[0][j] == '@' || grid[0][j] == '=') {
                } else {
                    if (grid[0][j] != '@' || grid[0][j] != '=') {
                        if (grid[i][j] == '@' && grid[i - 1][j] == '@' && grid[i - 2][j] == '@' && grid[i - 3][j] == ' ') {
                            // Si c'est le cas, on place un jeton dans cette colonne pour bloquer la victoire
                            if (!estColonnePleine(j+1, grid)){
                                return j + 1;
                            }
                        } else if (grid[i][j] == '=' && grid[i - 1][j] == '=' && grid[i - 2][j] == '=' && grid[i - 3][j] == ' ') {
                            if (!estColonnePleine(j+1, grid)){
                                return j + 1;
                            }
                        }
                    }

                }
            }
        }
        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 6; i++) {

                if (grid[i][j] == '@' && grid[i][j + 1] == '@' && grid[i][j + 2] == '@' && grid[i][j + 3] == ' ') {
                    if ( i!=5 &&(grid[i+1][j+3] == '@' || grid[i+1][j+3] == '=') && i!=5 ){
                        //System.out.println("heheheha 1");
                        return j+4;
                    }else if (i==5) {
                        //System.out.println("heheheha 11");
                        return j+4;
                    }
                }
                if (grid[i][j] == '=' && grid[i][j + 1] == '=' && grid[i][j + 2] == '=' && grid[i][j + 3] == ' ') {
                    if ( i!=5 &&(grid[i+1][j+3] == '@' || grid[i+1][j+3] == '=') && i!=5 ){
                        //System.out.println("heheheha 2");
                        return j+4;
                    }else if (i==5){
                        //System.out.println("heheheha 22");
                        return j+4;
                    }
                }
                if (grid[i][j] == ' ' && grid[i][j + 1] == '@' && grid[i][j + 2] == '@' && grid[i][j + 3] == '@'){
                    if ( i!=5 &&( grid[i+1][j] == '@' || grid[i+1][j] == '=') && i!=5 ){
                        //System.out.println("heheheha 3");
                        return j+1;
                    }else if (i==5) {
                        // System.out.println("heheheha 33");
                        return j+1;
                    }
                }
                if (grid[i][j] == ' ' && grid[i][j + 1] == '=' && grid[i][j + 2] == '=' && grid[i][j + 3] == '='){
                    if ( i!=5 &&(grid[i+1][j] == '@' || grid[i+1][j] == '=') && i!=5 ){
                        //System.out.println("heheheha 4");
                        return j+1;
                    }else if (i==5){
                        //System.out.println("heheheha 44");
                        return j+1;
                    }
                }
            }
        }

        for (int i = 5; i >= 0; i--) {
            for (int j = 6; j >= 0; j--) {
                int consecutiveDABG = 0;
                if (i + 3 <= 5 && j + 3 <= 6) {
                    for (int k = 0; k <= 2; k++) {
                        if (grid[i + k][j + k] == '@' || grid[i + k][j + k] == '=') {
                            consecutiveDABG++;
                            if (consecutiveDABG == 3) {
                                if (j + k - 1 <=6 && grid[i + k][j + k -1 ] == '.') {
                                    return j + k - 1;
                                }
                            }
                        } else {
                            consecutiveDABG = 0;
                        }
                    }
                }
                consecutiveDABG = 0;
                if (i + 3 <= 5 && j - 3 >= 0) {
                    for (int k = 0; k <= 2; k++) {
                        if (grid[i + k][j - k] == '@' || grid[i + k][j - k] == '=') {
                            consecutiveDABG++;
                            if (consecutiveDABG == 3) {
                                if (j - k + 1 >= 0 && grid[i + k][j - k + 1] == '.') {
                                    return  j - k + 1;
                                }
                            }
                        } else {
                            consecutiveDABG = 0;
                        }
                    }
                }
            }
        }



    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 7; j++) {
            int consecutiveDABG = 0;
            if (i - 3 >= 0 && j - 3 >= 0) {
                for (int k = 0; k <= 2; k++) {
                    if (grid[i - k][j - k] == '@' || grid[i - k][j - k] == '=') {
                        consecutiveDABG++;
                        if (consecutiveDABG == 3) {
                            //System.out.println("aaaaaa      i-k: " + (i-k)+ "      j-k :    " +(j-k));
                            if (grid[i - k][j - k -1 ] == '@' || grid[i - k][j -k -1] == '=') {
                              //  System.out.println("hy");
                                return   j - k;
                            }
                        }
                    }
                }
            }
            consecutiveDABG = 0;
            if (i - 3 >= 0 && j + 3 <= 6) {
                for (int k = 0; k <= 2; k++) {
                    if (grid[i - k][j + k] == '@' || grid[i - k][j + k] == '=') {
                        consecutiveDABG++;
                        if (consecutiveDABG == 3) {
                            //System.out.println("aaaaaa      i-k: " + (i-k)+ "      j+k :    " +(j+k));
                            if (grid[i - k][j + k + 1] == '@' || grid[i - k][j + k + 1] == '=') {
                                //System.out.println("hy");
                                return   (j + k +2);
                            }
                        }
                    }
                }
            }
        }
    }


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDABG = 0;

                consecutiveDABG = 0;
                if (i - 3 >= 0 && j + 3 <= 6) {
                    for (int k = 0; k <= 2; k++) {
                        if (grid[i - k][j + k] == '@' || grid[i - k][j + k] == '='){
                            consecutiveDABG++;
                            if (consecutiveDABG == 3) {
                                if (j + k + 1 < 7 && grid[i - k][j + k + 1] == '.') {
                                    return j + k + 2;
                                }
                            }
                        } else {
                            consecutiveDABG = 0;
                        }
                    }
                }
                if (i - 3 >= 0 && j - 3 >= 0) {
                    for (int k = 0; k <= 2; k++) {
                        if (grid[i - k][j - k] == '@' || grid[i - k][j - k] == '=') {
                            consecutiveDABG++;
                            if (consecutiveDABG == 3) {
                                if (j - k + 1 >=0 && grid[i - k][j - k -1 ] == '.') {
                                    return j - k + 1;
                                }
                            }
                        } else {
                            consecutiveDABG = 0;
                        }
                    }
                }
            }
        }



                                // Si le joueur adverse ne peut pas gagner, on choisit une colonne au hasard
        Random tempo = new Random();
        int colonne = tempo.nextInt(7) + 1;
        if (colonne == 8) {
            colonne++;
        }
        while (estColonnePleine(colonne, grid)) {
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
}