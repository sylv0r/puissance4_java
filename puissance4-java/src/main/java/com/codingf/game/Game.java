
package com.codingf.game;


import com.codingf.grid.Grid;
import com.codingf.ia.Ia1;
import com.codingf.ia.Ia2;
import com.codingf.input.Input;
import com.codingf.player.Player;
import com.codingf.top10.Top10;
import com.codingf.winCondition.Flo;


import java.util.Scanner;

public class Game {
    private Grid grid;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    int result;
    String name;
    public Game() {
        this.grid = new Grid();
        this.player1 = new Player(0, '@');
        this.player2 = new Player(1, '=');
    }

    private void swapTurn() {
        if (this.currentPlayer.equals(this.player1)) {
            this.currentPlayer = this.player2;

        } else if ( this.currentPlayer.equals(this.player2)) {
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


    public void start() {
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(grid.generateGridString(grille));

        while (true) {
            System.out.print("colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();

            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)){
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)){
                System.out.println("veillez choisir un nombre entre 1 et 7");
                continue;
            }
            //Grid.colorize(grille);


            grid.place(grille,result,game, this.currentPlayer);

            if (Flo.winConditionVerticale(grille)){
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionHorizontale(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            }


            swapTurn();

        }
    }

    public void startIa1() {
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(grid.generateGridString(grille));

        int nb_coups = 0;
        while (true) {
            swapTurn();
            nb_coups++;
            System.out.print("colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();



            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)){
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)){
                System.out.println("veillez choisir un nombre entre 1 et 7");
                continue;
            }
            //Grid.colorize(grille);


            grid.place(grille,result,game, this.currentPlayer);
            swapTurn();
            grid.place(grille, Ia1.ia1(grille),game, this.currentPlayer);

            if (Flo.winConditionVerticale(grille)){
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionHorizontale(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            }
            System.out.println("Nombre de coup joué :"+ nb_coups);
        }
        System.out.println("Nombre de coup joué :"+ nb_coups);
    }

    public void startIa2() {
        Game game = new Game();
        currentPlayer = this.player1;
        char[][] grille = grid.generateGridSpace();
        System.out.println(grid.generateGridString(grille));

        while (true) {
            swapTurn();
            System.out.print("colone :  ");

            Scanner console = new Scanner(System.in);

            name = console.nextLine();

            try {
                result = Integer.parseInt(name);
                if (!Input.verrifInput(result)){
                    System.out.println("veillez choisir un nombre entre 1 et 7");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur, il faut entrer un nombre entier");
                continue;
            }

            if (!Input.verrifInput(result)){
                System.out.println("veillez choisir un nombre entre 1 et 7");
                continue;
            }


            grid.place(grille,result,game, this.currentPlayer);
            swapTurn();
            grid.place(grille, Ia2.ia2(grille),game, this.currentPlayer);


            if (Flo.winConditionVerticale(grille)){
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionHorizontale(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDABG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXBG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHD(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;


            } else if (Flo.winConditionDAHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            } else if (Flo.winConditionDXHG(grille)) {
                System.out.println(this.currentPlayer+"a gagner");
                break;
            }

        }
    }
}
