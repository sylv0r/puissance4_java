//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codingf.grid;

import com.codingf.game.Game;
import com.codingf.player.Player;

public class Grid {
    int age;

    public Grid() {
    }

    public static String generateGridString(char[][] grid) {
        StringBuilder sb = new StringBuilder();

        int i;
        for(i = 0; i < 7; ++i) {
            sb.append("  ");
            sb.append(i + 1);
            sb.append(" ");
        }

        sb.append("\n");

        for(i = 0; i < 6; ++i) {
            int j;
            for(j = 0; j < 7; ++j) {
                sb.append("┼───");
            }

            sb.append("┤\n");

            for(j = 0; j < 7; ++j) {
                sb.append("│ ");
                if (grid[i][j] == '@') {
                    sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                } else if (grid[i][j] == '=') {
                    sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                } else {
                    sb.append(grid[i][j]);
                }

                sb.append(" ");
            }

            sb.append("│\n");
        }

        for(i = 0; i < 7; ++i) {
            sb.append("┼───");
        }

        sb.append("│\n");
        return sb.toString();
    }

    public static void place(char[][] grid, int result, Game game, Player currentPlayer) {
        for(int i = 5; i >= 0; --i) {
            if (grid[i][result - 1] != '@' && grid[i][result - 1] != '=') {

                grid[i][result - 1] = game.actualPlayer(currentPlayer);
                System.out.println(generateGridString(grid));
                break;
            }
        }

    }

    public static char[][] generateGridSpace() {
        char[][] grid = new char[6][7];

        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 7; ++j) {
                grid[i][j] = ' ';
            }
        }

        return grid;
    }
}