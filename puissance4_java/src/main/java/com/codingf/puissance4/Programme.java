package com.codingf.puissance4;

import static com.codingf.grid.Grid.generateGridString;

public class Programme {
    public static void launcher(String[] args) {
        char[][] grid = new char[6][7];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        for (int i = 0; i < 6; i++) {
            grid[i][0] = '.';

        }


        System.out.println(generateGridString(grid));

    }
}

