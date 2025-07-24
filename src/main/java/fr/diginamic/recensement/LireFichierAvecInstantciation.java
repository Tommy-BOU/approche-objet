package fr.diginamic.recensement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class LireFichierAvecInstantciation {
    public static Collection<Ville> readFile(String fileName) {
        Collection<Ville> villes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String headerLine = br.readLine();
            while ((line = br.readLine()) != null) {

                String[] values = line.split(";");

                String codeDepartement = values[2];
                String nomVille = values[6];
                String nomDeRegion = values[1];
                int populationTotale = Integer.parseInt(values[9].replaceAll("\\s+",""));
                int codeCommune = Integer.parseInt(values[5]);
                int codeRegion = Integer.parseInt(values[0]);
                Ville newVille = new Ville(nomVille, codeDepartement, nomDeRegion, populationTotale, codeCommune, codeRegion);
                villes.add(newVille);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
        return villes;
    }
}
