
package com.codingf.game;


import com.codingf.grid.Grid;
import com.codingf.player.Player;


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

        } else if ( this.currentPlayer == null) {
            this.currentPlayer = this.player1;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    //public String actualplayer(){

    //}

    public char actualPlayer(Player play){

        char ez = play.getToken().tokenChar;
        return ez;
    }


    public void start() {
        Game game = new Game();
        currentPlayer = this.player2;
        char[][] grille = grid.generateGridSpace();
        System.out.println(grid.generateGridString(grille));
        System.out.print("colone :  ");

        while (true) {

            Scanner console = new Scanner(System.in);

            name = console.nextLine();
            result = Integer.parseInt(name);

            grid.place(grille,result,game, this.currentPlayer);
            System.out.print("colone :  ");
            swapTurn();


            }
        }
    }
