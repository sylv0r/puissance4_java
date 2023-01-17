package com.codingf.top10;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.codingf.joueur.Joueur;
public class Top10 {
    public static void main(String[] args) {
        // Créer la liste du top 10
        List<Joueur> players = new ArrayList<>();
        players.add(new Joueur("Julien", 39));
        players.add(new Joueur("Zineb", 10));
        players.add(new Joueur("Alexandre", 123));
        players.add(new Joueur("Florian", 95));
        players.add(new Joueur("Jordan", 12));
        players.add(new Joueur("Lucas", 130));
        players.add(new Joueur("Théo", 145));
        players.add(new Joueur("Matheo", 34));
        players.add(new Joueur("Raphael", 100));
        players.add(new Joueur("ytr", 144));
        players.add(new Joueur("kjh", 131));
        // Afficher les joueurs par leur score
        Collections.sort(players);

        // Ecrit le top 10 dans un fichier .txt
        try (FileOutputStream fw = new FileOutputStream("top10.txt", false)) {
            try (OutputStreamWriter osw = new OutputStreamWriter(fw, "UTF-8")) {
                try (BufferedWriter bw = new BufferedWriter(osw)) {
                    for (int i = 0; i < 10; i++) {
                        bw.write(players.get(i).getName() + ": " + players.get(i).getScore());
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void affiche() {

    }
}
