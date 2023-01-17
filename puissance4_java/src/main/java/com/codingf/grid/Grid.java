package com.codingf.grid;

import com.codingf.game.Game;
import com.codingf.player.Player;

public class Grid {


    int age;
    /*public static String generateGridString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 7; j++) {

            sb.append(j + 1);
            sb.append("   ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 7; j++) {
                sb.append("┼───");

            }
            sb.append("┤\n");
            for (int j = 0; j < 7; j++) {
                sb.append("│ ");
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("│\n");
        }
        for (int j = 0; j < 7; j++) {
            sb.append("┼───");
        }
        sb.append("│\n");
        //couleurs


        return sb.toString();
    }*/
    public static String generateGridString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 7; j++) {

            sb.append(j + 1);
            sb.append("    ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 7; j++) {
                sb.append("┼───");
            }
            sb.append("┤\n");
            for (int j = 0; j < 7; j++) {
                sb.append("│ ");
                if (grid[i][j] == '@') {
                    sb.append("\033[31m"+grid[i][j]+"\033[0m");  // Change la couleur en rouge si le jeton est '@'
                } else if (grid[i][j] == '=') {
                    sb.append("\033[34m"+grid[i][j]+"\033[0m");  // Change la couleur en bleu si le jeton est '='
                }else{
                    sb.append(grid[i][j]);
                }
                sb.append(" ");
            }

            sb.append("│\n");
        }
        for (int j = 0; j < 7; j++) {
            sb.append("┼───");
        }
        sb.append("│\n");
        return sb.toString();
    }




    /*public static void colorize(char[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (grid[i][j] == '@') {
                    grid[i][j] = '\u001B'+"[31m"+"@"+'\u001B'+"[0m";  // Change la couleur en rouge si le jeton est '@'
                } else if (grid[i][j] == '=') {
                    grid[i][j] = '\u001B'+"[34m"+"="+'\u001B'+"[0m";  // Change la couleur en bleu si le jeton est '='
                }
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }*/






    public static void place(char[][] grid, int result, Game game, Player currentPlayer) {
        for (int i = 5; i >= 0; i--) {
            if (grid[i][result - 1] == '@' || grid[i][result - 1] == '=') {
            } else {
                grid[i][result - 1] = game.actualPlayer(currentPlayer);
                System.out.println(generateGridString(grid));

                break;
            }
        }
    }



    public static char[][] generateGridSpace() {
        char[][] grid = new char[6][7];

        // Initialize grid with empty spaces
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        return grid;
    }


}









   //         1   2   3   4   5   6   7
   //         |   |   |   |   |   |   |   |
   //         |---+---+---+---+---+---+---|
   //         |   |   |   |   |   |   |   |
    //        |---+---+---+---+---+---+---|
   //         |   |   |   | = |   | @ |   |
   //         |---+---+---+---+---+---+---|
  //          |   |   | @ | @ | = | @ |   |
  //          |---+---+---+---+---+---+---|
  //          |   |   | = | = | @ | = |   |
   //         |---+---+---+---+---+---+---|
    //        |   | @ | = | @ | = | @ | = |
     //       \===========================/
