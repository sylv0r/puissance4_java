package com.codingf;


import static com.codingf.grid.Grid.generateGridString;

public class Flo {

    static int win1a = 0;
    static int win1x = 0;
    static int win2a = 0;
    static int win2x = 0;
    static int win3a = 0;
    static int win3x = 0;

    static int j = 0;
    static int i = 0;

    static char[][] grid = new char[6][7];


    static boolean Fuite = false;
    public static void main(String[] args) {



        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = ' ';
            }
        }
        grid[0][0] = 'A';
        grid[1][0] = 'A';
        grid[2][0] = ' ';
        grid[3][0] = ' ';
        grid[4][0] = ' ';
        grid[5][0] = ' ';

        grid[0][1] = ' ';
        grid[1][1] = 'X';
        grid[2][1] = 'A';
        grid[3][1] = ' ';
        grid[4][1] = ' ';
        grid[5][1] = ' ';

        grid[0][2] = 'X';
        grid[1][2] = ' ';
        grid[2][2] = 'A';
        grid[3][2] = 'A';
        grid[4][2] = ' ';
        grid[5][2] = ' ';

        grid[0][3] = 'X';
        grid[1][3] = 'A';
        grid[2][3] = ' ';
        grid[3][3] = 'A';
        grid[4][3] = 'A';
        grid[5][3] = ' ';

        grid[0][4] = ' ';
        grid[1][4] = 'X';
        grid[2][4] = 'A';
        grid[3][4] = ' ';
        grid[4][4] = ' ';
        grid[5][4] = ' ';

        grid[0][5] = ' ';
        grid[1][5] = ' ';
        grid[2][5] = 'X';
        grid[3][5] = 'A';
        grid[4][5] = ' ';
        grid[5][5] = ' ';

        grid[0][6] = ' ';
        grid[1][6] = ' ';
        grid[2][6] = ' ';
        grid[3][6] = 'A';
        grid[4][6] = ' ';
        grid[5][6] = ' ';


        // DEBUT WINS CONDITIONS VERTICALES
        /*for ( j = 0; j < 7; j++) {
            win1x = 0;
            win1a = 0;
            for ( i = 0; i < 6; i++) {
                if (grid[i][j] == 'A' && Fuite == false) {
                    win1x = 0;
                    win1a = win1a + 1;
                    System.out.println(win1a + " 1A");
                    winConditionV();
                } else {
                    if (grid[i][j] == 'X' && Fuite == false) {
                        win1a = 0;
                        win1x = win1x + 1;
                        System.out.println(win1x + " 1X");
                        winConditionV();
                    } else {
                        if (grid[i][j] == ' ') {
                        } else {

                        }

                    }
                }
            }
        }*/
            // FIN DES WINS CONDITIONS VERTICALES

            // DEBUT WINS CONDITIONS HORIZONTALES



            winConditionDABD();
            winConditionDXBD();

        // FIN DES WINS CONDITIONS HORIZONTALES

            // DEBUT WINS CONDITIONS DIAGONALES
        /*for ( i = 0; i < 6; i++) {
            win2x = 0;
            win2a = 0;
            for ( j = 0; j < 7; j++) {
                if (grid[i][j] == 'A' && Fuite == false) {
                    win2x = 0;
                    win2a = win2a + 1;
                    System.out.println(win2a + " 2A");
                    winConditionH();
                } else {
                    if (grid[i][j] == 'X' && Fuite == false) {
                        win2a = 0;                        win2x = win2x + 1;
                        System.out.println(win2x + " 2X");
                        winConditionH();
                    } else {
                        if (grid[i][j] == ' ') {
                        } else {

                        }

                    }
                }
            }
        }*/
            // FIN DES WINS CONDITIONS DIAGONALES



        System.out.println(generateGridString(grid));
    }
    private static void winConditionV() {
        if (win1a == 4 || win1x == 4) {
            System.out.println("Victoire sur la ligne verticale " + (j + 1));
            Fuite = true;

        }
    }
    private static void winConditionH() {
        if (win2a == 4 || win2x == 4) {
            System.out.println("Victoire sur la ligne horizontale " + (i + 1));
            Fuite = true;

        }
    }

    private static void winConditionDABD(){
        for ( j = 0; j < 5; j++) {
            win3x = 0;
            win3a = 0;
            for (i = 0; i < 1; i++) {
                if (grid[i][j] == 'A' && Fuite == false) {
                    win3x = 0;
                    win3a = win3a + 1;
                    System.out.println(grid[i][j] + " 3A");
                    if (grid[i + 1][j + 1] == 'A') {
                        win3x = 0;
                        win3a = win3a + 1;
                        System.out.println(grid[i + 1][j + 1] + " 3A");
                        if (grid[i + 2][j + 2] == 'A') {
                            win3x = 0;
                            win3a = win3a + 1;
                            System.out.println(grid[i + 2][j + 2] + " 3A");
                            if (grid[i + 3][j + 3] == 'A') {
                                win3x = 0;
                                win3a = win3a + 1;
                                System.out.println(grid[i + 3][j + 3] + " 3A");
                                System.out.println("Victoire sur la ligne diagonale A" + j);
                                Fuite = true;
                            } else if (grid[i + 3][j + 3] == ' ' && Fuite == false) {
                                System.out.println("4");
                            } else {
                                break;
                            }
                        } else if (grid[i + 2][j + 2] == ' ' && Fuite == false) {
                            System.out.println("3");
                        } else {
                            break;
                        }
                    } else if (grid[i + 1][j + 1] == ' ' && Fuite == false) {
                        System.out.println("2");
                    } else {
                        break;
                    }
                } else if (grid[i][j] == ' ' && Fuite == false) {
                    System.out.println("1");
                    System.out.println(i);
                    System.out.println(j);
                } else {
                    break;
                }
            }
        }
    }

    private static void winConditionDXBD(){
        for ( j = 0; j < 7; j++) {
            win3x = 0;
            win3a = 0;
            for (i = 0; i < 0; i++) {
                if (grid[i][j] == 'X' && Fuite == false) {
                    win3x = 0;
                    win3a = win3a + 1;
                    System.out.println(grid[i][j] + " 3X");
                    if (grid[i + 1][j + 1] == 'X') {
                        win3x = 0;
                        win3a = win3a + 1;
                        System.out.println(grid[i + 1][j + 1] + " 3X");
                        if (grid[i + 2][j + 2] == 'X') {
                            win3x = 0;
                            win3a = win3a + 1;
                            System.out.println(grid[i + 2][j + 2] + " 3X");
                            if (grid[i + 3][j + 3] == 'X') {
                                win3x = 0;
                                win3a = win3a + 1;
                                System.out.println(grid[i + 3][j + 3] + " 3X");
                                System.out.println("Victoire sur la ligne diagonale X" + j);
                                Fuite = true;
                            } else if (grid[i + 3][j + 3] == ' ' && Fuite == false) {
                                System.out.println("Rien");
                            } else {
                                break;
                            }
                        } else if (grid[i + 2][j + 2] == ' ' && Fuite == false) {
                            System.out.println("Rien");
                        } else {
                            break;
                        }
                    } else if (grid[i + 1][j + 1] == ' ' && Fuite == false) {
                        System.out.println("Rien");
                    } else {
                        break;
                    }
                } else if (grid[i][j] == ' ' && Fuite == false) {
                    System.out.println("Rien");
                } else {
                    break;
                }
            }
        }
    }
}