package com.codingf.joueur;

// Joueur class
public class Joueur implements Comparable<Joueur>{
    private String name;
    private int score;

    public Joueur(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Joueur joueur) {
        return Integer.compare(this.score, joueur.score);
    }
}