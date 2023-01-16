package com.codingf.grid;



public class Grid {
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