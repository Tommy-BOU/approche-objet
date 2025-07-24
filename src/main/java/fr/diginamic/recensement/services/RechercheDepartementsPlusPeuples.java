package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Departement;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Region;

import java.util.*;

public class RechercheDepartementsPlusPeuples extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Departement> sortedDepartements = new ArrayList<>(recensement.getDepartements());

        Collections.sort(sortedDepartements, new Comparator<Departement>() {
            @Override
            public int compare(Departement v1, Departement v2) {
                return Integer.compare(v2.getPopulation(), v1.getPopulation());
            }
        });

        System.out.println("Les 10 départements les plus peuplées de France sont :");
        int limit = Math.min(10, sortedDepartements.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(sortedDepartements.get(i));
        }
        Utils.pressEnterToContinue();
    }
}
