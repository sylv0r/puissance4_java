package com.codingf.top10;

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

        }
        catch (IOException e) {
            System.out.println("NON");
        }

    }

    // écriture dans le fichier

    public static void writeTop10() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("top10.txt"));
            File top10 = new File("../top10.txt");
            BufferedWriter sortie;
            if (top10.exists()) {
                sortie = new BufferedWriter(new FileWriter("top10.txt"));
            } else {
                sortie = new BufferedWriter(new FileWriter("top10.txt", true));
            }
            sortie.write("bastien" + " : " + "5" + "\n");
            //sortie.write(currentPlayer.name() + " : " + currentPlayer.getTurn() + "\n");
            sortie.close();
        } catch (
                IOException e) {
            System.out.println("ca marche pas");
        }
    }

}