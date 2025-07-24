package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;

public class RechercheVillesPlusPeupleesDepartement extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Entrez le code du département à recherché :");

        String userInput = scanner.nextLine();

        List<Ville> villesDep = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equals(userInput)) {
                villesDep.add(ville);
            }
        }

        Collections.sort(villesDep, new Comparator<Ville>() {
            @Override
            public int compare(Ville v1, Ville v2) {
                return Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale());
            }
        });

        if (villesDep.isEmpty()) {
            System.out.println("Erreur - Département introuvable");
        } else {
            System.out.println("Les 10 villes les plus peuplées du " + userInput + " sont :");
            int limit = Math.min(10, villesDep.size());
            for (int i = 0; i < limit; i++) {
                System.out.println(villesDep.get(i));
            }
        }

        Utils.pressEnterToContinue();
    }
}
