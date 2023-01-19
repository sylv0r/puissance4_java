package com.codingf.top10;

import com.codingf.player.Player;

import java.io.*;
import java.util.*;


public class Top10 {


    public static void readTop10() {
        try {
            BufferedReader top10 = new BufferedReader(new FileReader("top10.txt"));
            Scanner fileScan = new Scanner(top10);

            while (fileScan.hasNextLine()) {
                String topInfo = fileScan.nextLine();
                String[] infos = topInfo.split(" : ");
                System.out.println(infos[0] + " a gagné en " + infos[1] + " coups");
            }

        } catch (IOException e) {
            System.out.println("NON");
        }

    }

    // écriture dans le fichier

    public static void writeTop10(String name, int score) {

        try {
            BufferedWriter sortie = new BufferedWriter(new FileWriter("top10.txt", true));
            sortie.write(name + " : " + score + "\n");
            sortie.close();
        } catch (
                IOException e) {
            System.out.println("ca marche pas");
        }
    }
}