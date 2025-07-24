package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Entrez le code de la région à recherchée :");
        String userInput = scanner.nextLine();
        int codeRegion = Utils.inputToInt(userInput);

        int pop = 0;
        String nomRegion = null;
        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeRegion() == codeRegion) {
                pop += ville.getPopulationTotale();
                nomRegion = ville.getNomRegion();
            }
        }
        if (pop == 0) {
            System.out.println("Erreur - Région introuvable");
        } else {
            System.out.println("Population totale de " + nomRegion);
            System.out.println(pop + " habitants.");
        }
        Utils.pressEnterToContinue();
    }
}
