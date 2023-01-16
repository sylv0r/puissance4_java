package com.codingf.grid;

import com.codingf.player.Player;

public class Token {
    //champ
    private char tokenChar;
    private Player owner;

    //constructor

    public Token(char c, Player player) {
        this.tokenChar = c;
        this.owner = player;

    }
    //getters || setters


    public Player getOwner() {
        return owner;
    }

    //methode
    @Override
    public String toString(){
        return Character.toString(this.tokenChar);
    }
}
