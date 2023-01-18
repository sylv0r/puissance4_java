package com.codingf.winCondition;


import com.codingf.grid.Grid;

public class WinConditions {

    static int win1a = 0;
    static int win1x = 0;
    static int win2a = 0;
    static int win2x = 0;


    static int j = 0;
    static int i = 0;


    static boolean Fuite = false;

    // DEBUT WINS CONDITIONS VERTICALES
    public static boolean winConditionVerticale(char[][] grid) {
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (grid[i][j] == '@' && grid[i + 1][j] == '@' && grid[i + 2][j] == '@' && grid[i + 3][j] == '@') {
                    System.out.println("Victoire sur la colonne @ " + (j + 1));
                    return true;
                }
                if (grid[i][j] == '=' && grid[i + 1][j] == '=' && grid[i + 2][j] == '=' && grid[i + 3][j] == '=') {
                    System.out.println("Victoire sur la colonne = " + (j + 1));
                    return true;
                }
            }
        }
        return false;
    }
    // FIN DES WINS CONDITIONS VERTICALES

    // DEBUT WINS CONDITIONS HORIZONTALES
    public static boolean winConditionHorizontale(char[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == '@' && grid[i][j + 1] == '@' && grid[i][j + 2] == '@' && grid[i][j + 3] == '@') {
                    System.out.println("Victoire sur la ligne A " + (i + 1));
                    Grid.generateGridStringFinish(grid,i,j,i,j+1,i,j+2,i,j+3);
                    //Grid.generateGridStringFinish(grid,grid[i][j], grid[i][j + 1] , grid[i][j + 2], grid[i][j + 3]);
                    return true;
                }
                if (grid[i][j] == '=' && grid[i][j + 1] == '=' && grid[i][j + 2] == '=' && grid[i][j + 3] == '=') {
                    System.out.println("Victoire sur la ligne A " + (i + 1));
                    return true;
                }
            }
        }
        return false;
    }
    // FIN WINS CONDITIONS HORIZONTALES



    public static boolean winConditionDABD(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDABD = 0;
                if (i + 3 < 6 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j + k] == '@') {
                            consecutiveDABD++;
                        }
                    }
                    if (consecutiveDABD == 4) {
                        System.out.println("Victoire sur la ligne diagonale @" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean winConditionDXBD(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXBD = 0;
                if (i + 3 < 6 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j + k] == '=') {
                            consecutiveDXBD++;
                        }
                    }
                    if (consecutiveDXBD == 4) {
                        System.out.println("Victoire sur la ligne diagonale = " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean winConditionDABG(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDABG = 0;
                if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j - k] == '@') {
                            consecutiveDABG++;
                        }
                    }
                    if (consecutiveDABG == 4) {
                        System.out.println("Victoire sur la ligne diagonale bas gauche @ " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean winConditionDXBG(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXBG = 0;
                if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j - k] == '=') {
                            consecutiveDXBG++;
                        }
                    }
                    if (consecutiveDXBG == 4) {
                        System.out.println("Victoire sur la ligne diagonale bas gauche = " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean winConditionDAHD(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDAHD = 0;
                if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j + k] == '@') {
                            consecutiveDAHD++;
                        }
                    }
                    if (consecutiveDAHD == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute droite @ " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean winConditionDXHD(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXHD = 0;
                if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j + k] == '=') {
                            consecutiveDXHD++;
                        }
                    }
                    if (consecutiveDXHD == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute droite = " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean winConditionDAHG(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDAHG = 0;
                if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j - k] == '@') {
                            consecutiveDAHG++;
                        }
                    }
                    if (consecutiveDAHG == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute gauche @ " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean winConditionDXHG(char[][] grid){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXHG = 0;
                if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j - k] == '=') {
                            consecutiveDXHG++;
                        }
                    }
                    if (consecutiveDXHG == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute gauche = " + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
