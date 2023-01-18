package com.codingf.player;

import com.codingf.grid.Token;


public class Player {

    //champ
    private  int id;
    private Token token;

    //constructeur

    public Player(int playerId, char c) {
        this.id = playerId;
        this.token = new Token(c, this);

    }

    // Getter et setteur
    public Token getToken(){
        return this.token;
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