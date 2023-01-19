
package com.codingf.game;


import com.codingf.grid.Grid;
import com.codingf.ia.Ia1;
import com.codingf.input.Input;
import com.codingf.player.Player;
import com.codingf.winCondition.WinConditions;
import com.codingf.grid.Grid;


import java.util.Scanner;

import static com.codingf.grid.Grid.generateGridString;

public class Game {
    private Grid grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    int result;
    String name;
    boolean remake = false;

    public Game() {
        this.grid = new Grid();
        this.player1 = new Player(0, '@' );
        this.player2 = new Player(1, '=');
    }


    private void swapTurn() {

        if (this.currentPlayer.equals(this.player1)) {
            this.currentPlayer = this.player2;

        } else if (this.currentPlayer.equals(this.player2)) {
            this.currentPlayer = this.player1;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    //public String actualplayer(){

    //}

    public char actualPlayer(Player play) {

        char ez = play.getToken().tokenChar;
        return ez;
    }

    public void displayWinner(Player winner)  {
        System.out.println("Le gagnant est " + winner.name+ " avec le couleur "+winner.color) ;
    }


    public void start() {
        Player.setPlayerName(player1);
        Player.setPlayerColor(player1);
        Player.setPlayerName(player2);
        Player.setPlayerColor(player2);
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(generateGridString(grille, currentPlayer));


        while (true) {
            System.out.print(this.currentPlayer.name + " choisi une colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();

            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)) {
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)) {
                System.out.println("veillez choisir un nombre entre 1 et 7");

                continue;
            }
            //Grid.colorize(grille);


            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                displayWinner(this.currentPlayer);
                break;
            }


            swapTurn();


        }
    }
    public void restart() {
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(generateGridString(grille, currentPlayer));


        while (true) {
            System.out.print(this.currentPlayer.name + " choisi une colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();

            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)) {
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)) {
                System.out.println("veillez choisir un nombre entre 1 et 7");

                continue;
            }
            //Grid.colorize(grille);


            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                displayWinner(this.currentPlayer);
                break;
            }




            swapTurn();


        }
    }

    public void startIa1() {
        Player.setPlayerName(player1);
        Player.setPlayerColor(player1);
        Player.setPlayerName(player2);
        Player.setPlayerColor(player2);
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(generateGridString(grille, currentPlayer));


        while (true) {
            swapTurn();
            System.out.print("colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();


            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)) {
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)) {
                System.out.println("veillez choisir un nombre entre 1 et 7");
                continue;
            }


            //Grid.colorize(grille);


            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){

                break;
            }
            swapTurn();
            grid.place(grille, Ia1.ia1(grille), game, this.currentPlayer);
             if (callAll(grille)){
                 break;
             }



        }
    }


    // FONCTION DES WINS CONDITIONS
    public boolean callAll(char[][] grille) {
        if (WinConditions.winConditionVerticale(grille)) {
            return true;
        } else if (WinConditions.winConditionHorizontale(grille)) {

            return true;


        } else if (WinConditions.winConditionDABD(grille)) {

            return true;
        } else if (WinConditions.winConditionDXBD(grille)) {

            return true;


        } else if (WinConditions.winConditionDABG(grille)) {
            return true;
        } else if (WinConditions.winConditionDXBG(grille)) {

            return true;


        } else if (WinConditions.winConditionDAHD(grille)) {
            return true;
        } else if (WinConditions.winConditionDXHD(grille)) {
            return true;


        } else if (WinConditions.winConditionDAHG(grille)) {
            return true;
        } else if (WinConditions.winConditionDXHG(grille)) {
            return true;
        }

        return false;
    }
    // FONCTION DES WINS CONDITIONS

}

