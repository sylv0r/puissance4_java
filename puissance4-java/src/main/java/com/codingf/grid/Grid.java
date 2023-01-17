package com.codingf.grid;



public class











Grid {
    public static String generateGridString(char[][] grid) {
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
        return sb.toString();
    }

    public static void main(String[] args) {
        char[][] grid = new char[6][7];

        // Initialize grid with empty spaces
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        for (int i = 0; i < 6; i++) {
            grid[i][0] = '.';

        }

        // Example: set some grid spaces to 'X' and 'O'
        grid[5][6] = '=';

        // Print the grid
        System.out.println(generateGridString(grid));
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
