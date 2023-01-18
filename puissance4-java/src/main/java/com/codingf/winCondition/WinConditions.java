package com.codingf.winCondition;


public class WinConditions {

    public static boolean Fuite = false;

    // DEBUT WINS CONDITIONS VERTICALES
    public static boolean winConditionVerticale(char[][] grid) {
        for (int j = 0; j < 7; j++) { // Première boucle qui change de colonne verticale
            for (int i = 0; i < 3; i++) { // Seconde boucle qui parcours toutes les lignes de la colonne j
                if (grid[i][j] == '@' && grid[i + 1][j] == '@' && grid[i + 2][j] == '@' && grid[i + 3][j] == '@') { // SI la case parcourue contient '@' puis celle en dessous de 1, puis celle en dessous de 2, puis celle en dessous de 3
                    System.out.println("Victoire sur la colonne @ " + (j + 1)); // Victoire
                    return true;
                }
                if (grid[i][j] == '=' && grid[i + 1][j] == '=' && grid[i + 2][j] == '=' && grid[i + 3][j] == '=') {
                    System.out.println("Victoire sur la colonne = " + (j + 1));
                    return true;
                }
            }
        }
        return false;
    }
    // FIN DES WINS CONDITIONS VERTICALES

    // DEBUT WINS CONDITIONS HORIZONTALES
    public static boolean winConditionHorizontale(char[][] grid) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == '@' && grid[i][j + 1] == '@' && grid[i][j + 2] == '@' && grid[i][j + 3] == '@') {
                    grid[i][j] ='A';
                    System.out.println("Victoire sur la ligne A " + (i + 1));
                    return true;
                }
                if (grid[i][j] == '=' && grid[i][j + 1] == '=' && grid[i][j + 2] == '=' && grid[i][j + 3] == '=') {
                    System.out.println("Victoire sur la ligne A " + (i + 1));
                    return true;
                }
            }
        }
            return false;
    }
    // FIN WINS CONDITIONS HORIZONTALES



        public static boolean winConditionDABD(char[][] grid){
            for (int i = 0; i < 6; i++) { // Première boucle qui parcours toutes les cases de la ligne 0, 1 par 1, après la fin de la Seconde boucle
                for (int j = 0; j < 7; j++) { // Seconde boucle qui parcours toutes les cases varticales
                    int winDataDABD = 0; // Stocke le score
                    if (i + 3 < 6 && j + 3 < 7 && Fuite == false) { // empeche les OutOfRange en detectant si une possible diagonale depasse les limites de la bordure
                        for (int k = 0; k <= 3; k++) { // Troisieme boucle qui parcours les 3 prochaines cases, vers le bas droit, à partir de celle détectée initialement
                            if (grid[i + k][j + k] == '@') { // SI la cases en bas à droite ,depuis celle initiale + k, à le meme jetons
                                winDataDABD++; // Augmente de 1 le score winDataDABD
                            }
                        }
                        if (winDataDABD == 4) { // SI score winDataDABD est égale à 4
                            System.out.println("Victoire sur la ligne diagonale @" + (j + 1));
                            Fuite = true; // Empeche les autres vérifications d'etre effectuées
                            return true; // Met fin au jeu
                        }
                    }
                }
            }
            return false;
        }


        public static boolean winConditionDXBD(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDXBD = 0;
                    if (i + 3 < 6 && j + 3 < 7 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i + k][j + k] == '=') {
                                winDataDXBD++;
                            }
                        }
                        if (winDataDXBD == 4) {
                            System.out.println("Victoire sur la ligne diagonale = " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        public static boolean winConditionDABG(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDABG = 0;
                    if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i - k][j - k] == '@') {
                                winDataDABG++;
                            }
                        }
                        if (winDataDABG == 4) {
                            System.out.println("Victoire sur la ligne diagonale bas gauche @ " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static boolean winConditionDXBG(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDXBG = 0;
                    if (i - 3 >= 0 && j - 3 >= 0 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i - k][j - k] == '=') {
                                winDataDXBG++;
                            }
                        }
                        if (winDataDXBG == 4) {
                            System.out.println("Victoire sur la ligne diagonale bas gauche = " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static boolean winConditionDAHD(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDAHD = 0;
                    if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i - k][j + k] == '@') {
                                winDataDAHD++;
                            }
                        }
                        if (winDataDAHD == 4) {
                            System.out.println("Victoire sur la ligne diagonale haute droite @ " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }


        public static boolean winConditionDXHD(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDXHD = 0;
                    if (i - 3 >= 0 && j + 3 < 7 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i - k][j + k] == '=') {
                                winDataDXHD++;
                            }
                        }
                        if (winDataDXHD == 4) {
                            System.out.println("Victoire sur la ligne diagonale haute droite = " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        public static boolean winConditionDAHG(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDAHG = 0;
                    if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i + k][j - k] == '@') {
                                winDataDAHG++;
                            }
                        }
                        if (winDataDAHG == 4) {
                            System.out.println("Victoire sur la ligne diagonale haute gauche @ " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static boolean winConditionDXHG(char[][] grid){
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int winDataDXHG = 0;
                    if (i + 3 < 6 && j - 3 >= 0 && Fuite == false) {
                        for (int k = 0; k <= 3; k++) {
                            if (grid[i + k][j - k] == '=') {
                                winDataDXHG++;
                            }
                        }
                        if (winDataDXHG == 4) {
                            System.out.println("Victoire sur la ligne diagonale haute gauche = " + (j + 1));
                            Fuite = true;
                            return true;
                        }
                    }
                }
            }
            return false;
        }


    }

