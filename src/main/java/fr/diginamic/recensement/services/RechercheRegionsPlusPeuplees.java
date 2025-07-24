package fr.diginamic.recensement.services;

import fr.diginamic.Utils;
import fr.diginamic.recensement.Recensement;
import fr.diginamic.recensement.Region;
import java.util.*;

public class RechercheRegionsPlusPeuplees extends MenuService {
    @Override
    public void traiter(Recensement recensement, Scanner scanner) {
        List<Region> sortedRegions = new ArrayList<>(recensement.getRegions());

        Collections.sort(sortedRegions, new Comparator<Region>() {
            @Override
            public int compare(Region v1, Region v2) {
                return Integer.compare(v2.getPopulation(), v1.getPopulation());
            }
        });

        System.out.println("Les 10 régions les plus peuplées de France sont :");
        int limit = Math.min(10, sortedRegions.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(sortedRegions.get(i));
        }
        Utils.pressEnterToContinue();
    }
}
