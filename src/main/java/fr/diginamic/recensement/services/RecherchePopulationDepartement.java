package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Entrez le code du département à recherchée :");
        String codeDepartement = scanner.nextLine();

        int pop = 0;

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equals(codeDepartement)) {
                pop += ville.getPopulationTotale();
            }
        }
        if (pop == 0) {
            System.out.println("Erreur - Département introuvable");
        } else {
            System.out.println("Population totale du " + codeDepartement);
            System.out.println(pop + " habitants.");
        }
        Utils.pressEnterToContinue();
    }
}
