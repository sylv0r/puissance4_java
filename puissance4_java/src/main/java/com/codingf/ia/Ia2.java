package com.codingf.ia;

import java.util.Random;

public class Ia2 {

    public static void ia2() {

        // random number <=1 / >+ 7
        Random tempo = new Random();

        int colonne = tempo.nextInt(6)+1;
        if(colonne == 6){
            colonne++;
        }

        System.out.println(colonne);



    }
}
