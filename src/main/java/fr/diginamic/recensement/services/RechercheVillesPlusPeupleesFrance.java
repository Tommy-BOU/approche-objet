package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Ville;

import java.util.*;

public class RechercheVillesPlusPeupleesFrance extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Ville> villes = new ArrayList<>(recensement.getVilles());

        Collections.sort(villes, new Comparator<Ville>() {
            @Override
            public int compare(Ville v1, Ville v2) {
                return Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale());
            }
        });

        System.out.println("Les 10 villes les plus peuplées de France sont :");
        int limit = Math.min(10, villes.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(villes.get(i));
        }
        Utils.pressEnterToContinue();
    }
}
