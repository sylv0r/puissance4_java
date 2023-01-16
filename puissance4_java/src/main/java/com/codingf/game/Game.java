package com.codingf.game;

import com.codingf.grid.Grid;
import com.codingf.player.Player;
import com.codingf.input.Input;


import java.util.Scanner;

import static com.codingf.input.Input.readInt;

public class Game {
    private Grid grid;
    private Player player1;
    private Player player2;

    public Game() {
        this.grid = new Grid();
        this.player1 = new Player(0 ,'X');
        this.player2 = new Player(1 ,'O');
    }

    public int start(){
        Scanner scan  = new Scanner(System.in);
        int input = readInt(scan);

        return input;
    }

}
