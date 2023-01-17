//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.codingf.grid;

import com.codingf.player.Player;

public class Token {
    public char tokenChar;
    private Player owner;

    public Token(char c, Player player) {
        this.tokenChar = c;
        this.owner = player;
    }

    public Player getOwner() {
        return this.owner;
    }

    public String toString() {
        return Character.toString(this.tokenChar);
    }
}
