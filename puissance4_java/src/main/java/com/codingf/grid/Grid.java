package com.codingf.grid;


import java.util.Scanner;

import static com.codingf.input.Input.readInt;

public class Grid {


    int age;
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


        // Example: set some grid spaces to 'X' and 'O'
        grid[5][0] = '=';

        // Print the grid
        System.out.println(generateGridString(grid));

        String name;

        int result = -1;

        Scanner console = new Scanner(System.in);

        while(true) {
            System.out.print("colone :  ");
            name = console.nextLine();
            result = Integer.parseInt(name);

            for (int i = 5; i >= 0; i--) {
                if (grid[i][result - 1] == '@' || grid[i][result - 1] == '=') {

                } else {
                    grid[i][result - 1] = '@';
                    break;
                }
            }


            System.out.println(generateGridString(grid));

        }
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
