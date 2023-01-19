package com.codingf.ia;

import com.codingf.game.Game;
import com.codingf.player.Player;

import java.util.Random;


public class Ia2 {

    public static int ia2(char[][] grid, Player currentPlayer) {
        // On commence par vérifier si le joueur adverse peut gagner en plaçant un jeton
        // dans une colonne donnée

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                if(grid[0][j] == '@' || grid[0][j] == '='){
                }else {
                    if (grid[i][j] == '@' && grid[i - 1][j] == '@' && grid[i - 2][j] == '@' && grid[i - 3][j] == ' ') {
                        // Si c'est le cas, on place un jeton dans cette colonne pour bloquer la victoire
                        return j + 1;

                    } else if (grid[i][j] == '=' && grid[i - 1][j] == '=' && grid[i - 2][j] == '=' && grid[i - 3][j] == ' ') {
                        return j + 1;

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
        //winConditionDABD
        for (int i = 0; i < 6; i++) {
            //System.out.println("i"+i);
            for (int j = 0; j < 7; j++) {
                //System.out.println("j"+j);
                int consecutiveDABD = 0;
                if (i + 3 < 6 && j + 3 < 7 ) {
                    for (int k = 0; k <= 3; k++) {

                        if (grid[i+k][j+k] == '@' || grid[i+k][j+k] == '=' ) {
                            //System.out.println((i+k)+"   "+(j+k)+ "      -----------------");
                            consecutiveDABD++;
                            //System.out.println("coooonnnssseeee   "+consecutiveDABD);
                        }
                        if (consecutiveDABD == 3) {
                            if (grid[i+1][j] == '@' || grid[i+1][j] == '='){
                                //System.out.println((j+1) + "ia joue");
                                return j+1 ;
                            }
                        }
                    }
                }
            }
        }
        //winConditionDAHD
        for (int i = 0; i < 6; i++) {
            //System.out.println("i" + i);

            for (int j = 0; j < 7; j++) {
                int consecutiveDAHD = 0;
                if (i - 3 >= 0 && j + 3 < 7) {
                    //System.out.println("j" + j);
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j + k] == '@' || grid[i - k][j + k] == '@') {
                            //System.out.println((i - k) + "   " + (j + k) + "      -----------------");
                            consecutiveDAHD++;
                            //System.out.println("coooonnnssseeee   " + consecutiveDAHD);
                        }
                        if (consecutiveDAHD == 3) {
                            //System.out.println("hehe");
                            if (grid[i- k][j+k+1] == '@' || grid[i -k][j +k+ 1] == '=') {
                                //System.out.println((j + 1) + "ia joue");
                                return j+ k+2;
                            }
                        }
                    }
                }
            }
        }
        //winConditionDABG
        for (int i = 0; i < 6; i++) {
            //System.out.println("i" + i);

            for (int j = 0; j < 7; j++) {
                //System.out.println("j" + j);

                int consecutiveDABG = 0;
                if (i - 3 >= 0 && j - 3 >= 0) {
                    for (int k = 0; k <= 2; k++) {
                        if (grid[i - k][j - k] == '@' || grid[i - k][j - k] == '=') {
                            //System.out.println((i - k) + "   " + (j - k) + "      -----------------");
                            consecutiveDABG++;
                            //System.out.println("coooonnnssseeee   " + consecutiveDABG);
                        }
                        if (consecutiveDABG == 3) {
                            //System.out.println((i -k)+"  "+(j-k -1 ));
                            //System.out.println((i)+"  "+(j ));
                            if (grid[i - k][j - k -1 ] == '@' || grid[i - k][j -k -1] == '=') {
                                //System.out.println((j) + "ia joue");
                                return j - k ;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            //System.out.println("i" + i);
            for (int j = 0; j < 7; j++) {
                //System.out.println("j" + j);
                int consecutiveDABG = 0;
                if (i - 3 >= 0 && j - 3 >= 0) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j - k] == '@' || grid[i - k][j - k] == '=') {
                            //System.out.println((i + k) + "   " + (j + k) + "      -----------------");
                            consecutiveDABG++;
                            //System.out.println("coooonnnssseeee   " + consecutiveDABG);
                        }

                        if (consecutiveDABG == 3) {
                            if (grid[i][j+1] == '@' || grid[i][j+1] == '=') {
                                //System.out.println((j + 1) + "ia joue");
                                return j+1;
                            }
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