package com.codingf;


import static com.codingf.grid.Grid.generateGridString;

public class Flo {
    public static void main(String[] args) {
        char[][] grid = new char[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        grid[0][0] = 'A';
        grid[1][0] = 'A';
        grid[2][0] = 'X';
        grid[3][0] = 'A';
        grid[4][0] = 'X';
        grid[5][0] = 'X';

        grid[0][1] = 'A';
        grid[1][1] = 'X';
        grid[2][1] = 'A';
        grid[3][1] = 'A';
        grid[4][1] = 'X';
        grid[5][1] = 'X';

        grid[0][2] = 'A';
        grid[1][2] = 'A';
        grid[2][2] = 'X';
        grid[3][2] = 'A';
        grid[4][2] = 'X';
        grid[5][2] = 'X';

        grid[0][3] = 'X';
        grid[1][3] = 'X';
        grid[2][3] = 'A';
        grid[3][3] = 'A';
        grid[4][3] = 'X';
        grid[5][3] = 'X';

        grid[0][4] = 'A';
        grid[1][4] = 'X';
        grid[2][4] = 'A';
        grid[3][4] = 'A';
        grid[4][4] = 'X';
        grid[5][4] = 'X';

        grid[0][5] = 'A';
        grid[1][5] = 'A';
        grid[2][5] = 'X';
        grid[3][5] = 'A';
        grid[4][5] = 'X';
        grid[5][5] = 'X';

        grid[0][6] = 'A';
        grid[1][6] = 'A';
        grid[2][6] = 'A';
        grid[3][6] = 'A';
        grid[4][6] = 'X';
        grid[5][6] = 'X';


        // DEBUT WINS CONDITIONS VERTICALES
        int win1 = 0;
        for (int j = 0; j < 7; j++){
            win1 = 0;
            for (int i = 0; i < 6; i++) {
                if (win1 == 4) {
                    System.out.println("Victoire sur la ligne verticale " + (j+1));
                    break;
                } else if (grid[i][j] == 'A') {
                    win1 = win1 + 1;
                } else {
                    win1 = 0;
                }

            }
    }
        // FIN DES WINS CONDITIONS VERTICALES

        // DEBUT WINS CONDITIONS HORIZONTALES
        int win2 = 0;
        for (int i = 0; i < 6; i++){
            win2 = 0;
            for (int j = 0; j < 7; j++) {
                if (win2 == 4) {
                    System.out.println("Victoire sur la ligne horizontale " + (i+1));
                    break;
                } else if (grid[i][j] == 'A') {
                    win2 = win2 + 1;
                } else {
                    win2 = 0;
                }

            }
        }
        // FIN DES WINS CONDITIONS HORIZONTALES



        System.out.println(generateGridString(grid));

    }
}