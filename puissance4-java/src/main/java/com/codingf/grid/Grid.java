
package com.codingf.grid;

import com.codingf.game.Game;
import com.codingf.player.Player;


public class Grid {
    int age;
    private static Player player1;
    private Player player2;
    static boolean tkt1 = false;
    static boolean tkt2 = false;


    public Grid() {
    }
    public static void resetTkt(){
        tkt1 = false;
        tkt2 = false;
    }

    public static String generateGridString(char[][] grid, Player currentPlayer) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < 7; ++i) {
            sb.append("  ");
            sb.append(i + 1);
            sb.append(" ");
        }

        sb.append("\n");

        for (i = 0; i < 6; ++i) {
            int j;
            for (j = 0; j < 7; ++j) {
                sb.append("┼───");
            }
            sb.append("┤\n");

            for (j = 0; j < 7; ++j) {
                sb.append("│ ");

                if (tkt2 == false && currentPlayer.getColor().equals("bleu") || tkt1 == true ) {
                    if (grid[i][j] == '@') {
                        sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                        tkt1 = true;
                    } else if (grid[i][j] == '=') {
                        sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                        tkt1 = true;
                    } else {
                        sb.append(grid[i][j]);
                    }
                }

                if (tkt1 == false && currentPlayer.getColor().equals("rouge") || tkt2 == true ) {
                    if (grid[i][j] == '@') {
                        sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                        tkt2 = true;

                    } else if (grid[i][j] == '=') {
                        sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                        tkt2 = true;

                    } else {
                        sb.append(grid[i][j]);
                    }
                }




                sb.append(" ");
            }

            sb.append("│\n");
        }

        for (i = 0; i < 7; ++i) {
            sb.append("┼───");
        }

        sb.append("│\n");
        return sb.toString();
    }

    public static void place(char[][] grid, int result, Game game, Player currentPlayer) {
        for (int i = 5; i >= 0; --i) {
            if (grid[i][result - 1] != '@' && grid[i][result - 1] != '=') {

                grid[i][result - 1] = game.actualPlayer(currentPlayer);
                System.out.println(generateGridString(grid, currentPlayer));
                break;
            }
        }

    }

    public static String generateGridStringFinish(char[][] grid, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < 6; ++i) {
            int j;
            for (j = 0; j < 7; ++j) {
                sb.append("┼───");
            }

            sb.append("┤\n");

            for (j = 0; j < 7; ++j) {
                sb.append("│ ");
                if (tkt2 == false &&  tkt1 == true ) {

                    if (i == x1 && j == y1 || i == x2 && j == y2 || i == x3 && j == y3 || i == x4 && j == y4) {
                        sb.append("\u001b[33m" + grid[i][j] + "\u001b[0m");
                    } else if (grid[i][j] == '@') {
                        sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                    } else if (grid[i][j] == '=') {
                        sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                    } else {
                        sb.append(grid[i][j]);
                    }
                }
                else if (tkt1 == false &&  tkt2 == true ) {

                    if (i == x1 && j == y1 || i == x2 && j == y2 || i == x3 && j == y3 || i == x4 && j == y4) {
                        sb.append("\u001b[33m" + grid[i][j] + "\u001b[0m");
                    } else if (grid[i][j] == '@') {
                        sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                    } else if (grid[i][j] == '=') {
                        sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                    } else {
                        sb.append(grid[i][j]);
                    }
                }

                sb.append(" ");
            }

            sb.append("│\n");
        }

        for (i = 0; i < 7; ++i) {
            sb.append("┼───");
        }

        sb.append("│\n");
        System.out.println(sb.toString());
        return sb.toString();
    }



    /*public static String generateGridStringFinish(char[][] grid, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        StringBuilder sb = new StringBuilder();

        int i;
        int j;

        for(i = 0; i < 6; ++i) {
            for (j = 0; j < 7; ++j) {
                if((i == x1 && j == y1) || (i == x2 && j == y2) || (i == x3 && j == y3) || (i == x4 && j == y4)){
                    sb.append("\u001b[33m" + grid[i][j] + "\u001b[0m");
                }else{
                    sb.append(grid[i][j]);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }*/



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





/*                 System.out.println(currentPlayer.getColor());
                if (grid[i][j] == '@' && currentPlayer.getColor().equals("bleu")) {
                    if(currentPlayer.getColor().equals("bleu") && grid[i][j] == '@'){
                        sb.append("\u001b[34m" + grid[i][j] + "\u001b[0m");
                    }
                }else if (grid[i][j] == '=' && currentPlayer.getColor().equals("rouge")) {
                    System.out.println(grid[i][j]);
                    if (currentPlayer.getColor().equals("rouge") && grid[i][j] == '=') {
                        sb.append("\u001b[31m" + grid[i][j] + "\u001b[0m");
                        System.out.println(grid[i][j]);
                    }
                } else {
                    sb.append(grid[i][j]);
                } */