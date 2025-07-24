package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Entrez le code commune de la ville à recherchée :");
        String userInput = scanner.nextLine();
        int codeCommune = Utils.inputToInt(userInput);

        int pop = 0;
        String commune = null;

        for (Ville ville : recensement.getVilles()){
            if (ville.getCodeCommune() == codeCommune){
                pop = ville.getPopulationTotale();
                commune = ville.getNom();
            }
        }
        if (pop == 0) {
            System.out.println("Erreur - ville introuvable");
        } else {
            System.out.println("Population totale de " + commune);
            System.out.println(pop + " habitants.");
        }

        Utils.pressEnterToContinue();
    }
}
