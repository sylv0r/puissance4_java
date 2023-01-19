
package com.codingf.game;


import com.codingf.grid.Grid;
import com.codingf.ia.Ia1;
import com.codingf.ia.Ia3;
import com.codingf.input.Input;
import com.codingf.player.Player;
import com.codingf.top10.Top10;
import com.codingf.winCondition.WinConditions;


import java.util.Scanner;

import static com.codingf.grid.Grid.generateGridString;

public class Game {
    private Grid grid;
    private Player player1;
    private Player player2;
    int score1;
    int score2;

    private Player currentPlayer;
    int result;
    String name;

    boolean remake = false;


    public Game() {
        this.grid = new Grid();
        this.player1 = new Player(0, '@');
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
    public char swapPlayer(Player play){
        if (play.equals(this.player1)) {
            return actualPlayer(this.player2);
        } else {
            return actualPlayer(this.player2);

        }
    }
    public static char actualPlayer(Player play) {

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

            if (this.currentPlayer.equals(this.player1)){
                score1+=1;
            }else {
                score2+=1;
            }

            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                displayWinner(this.currentPlayer);
                break;
            }

            if(this.currentPlayer.equals(this.player1)){
                Top10.writeTop10(this.currentPlayer.name,score1);
                score1 = 0;
                score2 = 0;
            }else {
                Top10.writeTop10(this.currentPlayer.name , score2);
                score1 = 0;
                score2 = 0;
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
            if (this.currentPlayer.equals(this.player1)){
                score1+=1;
            }else {
                score2+=1;
            }

            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                if (this.currentPlayer.equals(this.player1)){
                    displayWinner(this.currentPlayer);
                    Top10.writeTop10(this.currentPlayer.name,score1);
                    score1 = 0;
                    score2 = 0;
                }else {
                    displayWinner(this.currentPlayer);
                    Top10.writeTop10(this.currentPlayer.name , score2);
                    score1 = 0;
                    score2 = 0;
                }

                break;
            }






            swapTurn();


        }
    }

    public void startIa1() {
        Player.setPlayerColorAi(player1);
        Player.setPlayerColorAi(player2);
        Game game = new Game();
        currentPlayer = this.player2;
        char[][] grille = grid.generateGridSpace();
        System.out.println(generateGridString(grille, currentPlayer));


        while (true) {

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
            swapTurn();

            //Grid.colorize(grille);
            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                displayWinner(this.currentPlayer);
                break;
            }
            swapTurn();
            grid.place(grille, Ia1.ia1(grille), game, this.currentPlayer);
            if (callAll(grille)){

                    displayWinner(this.currentPlayer);

                break;
            }



        }
    }

    public void startIa3() {
        Player.setPlayerColorAi(player1);
        Player.setPlayerColorAi(player2);
        // Initialisation du jeu
        Game game = new Game();
        currentPlayer = this.player2;
        char[][] grille = grid.generateGridSpace();
        System.out.println(grid.generateGridString(grille,this.currentPlayer));
        while (true) {

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
            swapTurn();

            //Grid.colorize(grille);
            grid.place(grille, result, game, this.currentPlayer);
            if (callAll(grille)){
                    displayWinner(this.currentPlayer);
                break;
            }
            swapTurn();
            grid.place(grille, Ia3.ia3(grille,this.currentPlayer), game, this.currentPlayer);
            if (callAll(grille)){
                displayWinner(this.currentPlayer);
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

