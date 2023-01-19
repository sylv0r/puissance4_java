package com.codingf.player;

import com.codingf.grid.Token;

import java.util.Scanner;


public class Player {

    //champ
    private  int id;
    private Token token;
    public String name;
    public String color;
    private Object turn;

    private static int playerTurn = 5;


    //constructeur

    public Player(int playerId, char c) {
        this.id = playerId;
        this.token = new Token(c, this);
    }

    public static void getTurn(Player player) {
        player.turn = playerTurn;
    }

    // Getter et setteur
    public Token getToken(){
        return this.token;
    }
    public static void setPlayerName(Player player) {
        Scanner console = new Scanner(System.in);
        System.out.print("Entrer le nom du joueur: ");
        player.name = console.nextLine();
    }

    public static void setPlayerColor(Player player) {
        while (true) {
            System.out.print("Entrer la couleur du joueur: ");
            Scanner console = new Scanner(System.in);
            String colori = console.nextLine();

            if (!colori.equals("rouge") && !colori.equals("bleu")) {
                System.out.println("La couleur doit être 'rouge' ou 'bleu'");
                continue;
            } else {
                player.color = colori;
                break;
            }
        }
    }



    // Methodes

    @Override
    public  boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (other instanceof Player){
            Player player = (Player)other;

            return player.id == this.id;
        }else {
            return false;
        }
    }
}