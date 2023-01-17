package com.codingf;


public class Flo {

    static int win1a = 0;
    static int win1x = 0;
    static int win2a = 0;
    static int win2x = 0;


    static int j = 0;
    static int i = 0;

    static char[][] grid = new char[6][7];


    static boolean Fuite = false;

    /*public static void main(String[] args) {


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        grid[0][0] = 'A';
        grid[1][0] = ' ';
        grid[2][0] = 'A';
        grid[3][0] = 'A';
        grid[4][0] = 'X';
        grid[5][0] = 'A';

        grid[0][1] = 'A';
        grid[1][1] = ' ';
        grid[2][1] = ' ';
        grid[3][1] = ' ';
        grid[4][1] = ' ';
        grid[5][1] = ' ';

        grid[0][2] = 'A';
        grid[1][2] = ' ';
        grid[2][2] = ' ';
        grid[3][2] = ' ';
        grid[4][2] = ' ';
        grid[5][2] = ' ';

        grid[0][3] = 'A';
        grid[1][3] = ' ';
        grid[2][3] = ' ';
        grid[3][3] = 'X';
        grid[4][3] = ' ';
        grid[5][3] = ' ';

        grid[0][4] = ' ';
        grid[1][4] = ' ';
        grid[2][4] = 'X';
        grid[3][4] = ' ';
        grid[4][4] = ' ';
        grid[5][4] = ' ';

        grid[0][5] = ' ';
        grid[1][5] = 'X';
        grid[2][5] = ' ';
        grid[3][5] = ' ';
        grid[4][5] = ' ';
        grid[5][5] = ' ';

        grid[0][6] = 'X';
        grid[1][6] = ' ';
        grid[2][6] = ' ';
        grid[3][6] = ' ';
        grid[4][6] = ' ';
        grid[5][6] = ' ';
*/

        // DEBUT WINS CONDITIONS VERTICALES
    public static boolean winConditionVertical() {
        for (j = 0; j < 7; j++) {
            win1x = 0;
            win1a = 0;
            for (i = 0; i < 6; i++) {
                if (grid[i][j] == 'A' && Fuite == false) {
                    win1x = 0;
                    win1a = win1a + 1;
                    return winConditionV();
                } else {
                    if (grid[i][j] == 'X' && Fuite == false) {
                        win1a = 0;
                        win1x = win1x + 1;
                        return winConditionV();
                    } else {
                        if (grid[i][j] == ' ') {
                        } else {

                        }

                    }
                }
            }
        }
        return false;
    }
        // FIN DES WINS CONDITIONS VERTICALES

        // DEBUT WINS CONDITIONS HORIZONTALES



        // FIN DES WINS CONDITIONS HORIZONTALES

        // DEBUT WINS CONDITIONS DIAGONALES
        private static boolean winConditionHorizontale(){
            for ( i = 0; i < 6; i++) {
                win2x = 0;
                win2a = 0;
                for ( j = 0; j < 7; j++) {
                    if (grid[i][j] == 'A' && Fuite == false) {
                        win2x = 0;
                        win2a = win2a + 1;
                        return winConditionH();
                    } else {
                        if (grid[i][j] == 'X' && Fuite == false) {
                            win2a = 0;                        win2x = win2x + 1;
                            return winConditionH();
                        } else {
                            if (grid[i][j] == ' ') {
                            } else {

                            }

                        }
                    }
                }
            }
            return false;
        }


        // FIN DES WINS CONDITIONS DIAGONALES

       /* winConditionDABD();
        winConditionDXBD();
        winConditionDABG();
        winConditionDXBG();

        winConditionDAHD();
        winConditionDXHD();
        winConditionDAHG();
        winConditionDXHG();


        System.out.println(generateGridString(grid));
    }*/

    private static boolean winConditionV() {
        if (win1a == 4 || win1x == 4) {
            System.out.println("Victoire sur la ligne verticale " + (j + 1));
            Fuite = true;
            return Fuite;

        }
        return false;
    }

    private static boolean winConditionH() {
        if (win2a == 4 || win2x == 4) {
            System.out.println("Victoire sur la ligne horizontale " + (i + 1));
            Fuite = true;

        }
        return false;
    }

    private static boolean winConditionDABD() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDABD = 0;
                if (i + 3 < 6 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j + k] == 'A') {
                            consecutiveDABD++;
                        }
                    }
                    if (consecutiveDABD == 4) {
                        System.out.println("Victoire sur la ligne diagonale A" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private static boolean winConditionDXBD() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXBD = 0;
                if (i + 3 < 6 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j + k] == 'X') {
                            consecutiveDXBD++;
                        }
                    }
                    if (consecutiveDXBD == 4) {
                        System.out.println("Victoire sur la ligne diagonale X" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean winConditionDABG() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDABG = 0;
                if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j - k] == 'A') {
                            consecutiveDABG++;
                        }
                    }
                    if (consecutiveDABG == 4) {
                        System.out.println("Victoire sur la ligne diagonale bas gauche A" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean winConditionDXBG() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXBG = 0;
                if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j - k] == 'X') {
                            consecutiveDXBG++;
                        }
                    }
                    if (consecutiveDXBG == 4) {
                        System.out.println("Victoire sur la ligne diagonale bas gauche X" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean winConditionDAHD() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDAHD = 0;
                if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j + k] == 'A') {
                            consecutiveDAHD++;
                        }
                    }
                    if (consecutiveDAHD == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute droite A" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private static boolean winConditionDXHD() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXHD = 0;
                if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i - k][j + k] == 'X') {
                            consecutiveDXHD++;
                        }
                    }
                    if (consecutiveDXHD == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute droite X" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean winConditionDAHG() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDAHG = 0;
                if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j - k] == 'A') {
                            consecutiveDAHG++;
                        }
                    }
                    if (consecutiveDAHG == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute gauche A" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean winConditionDXHG() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int consecutiveDXHG = 0;
                if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                    for (int k = 0; k <= 3; k++) {
                        if (grid[i + k][j - k] == 'X') {
                            consecutiveDXHG++;
                        }
                    }
                    if (consecutiveDXHG == 4) {
                        System.out.println("Victoire sur la ligne diagonale haute gauche X" + (j + 1));
                        Fuite = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }


}