package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;

public class RechercheVillesPlusPeupleesRegion extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        System.out.println("Entrez le code de la région à recherché :");

        String userInput = scanner.nextLine();
        int codeRegion = Utils.inputToInt(userInput);

        String nomRegion = null;
        List<Ville> villesReg = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeRegion() == codeRegion) {
                villesReg.add(ville);
                nomRegion = ville.getNomRegion();
            }
        }

        Collections.sort(villesReg, new Comparator<Ville>() {
            @Override
            public int compare(Ville v1, Ville v2) {
                return Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale());
            }
        });

        if (villesReg.isEmpty()) {
            System.out.println("Erreur - Région introuvable");
        } else {
            System.out.println("Les 10 villes les plus peuplées de " + nomRegion + " sont :");
            int limit = Math.min(10, villesReg.size());
            for (int i = 0; i < limit; i++) {
                System.out.println(villesReg.get(i));
            }
        }
        Utils.pressEnterToContinue();
    }
}
