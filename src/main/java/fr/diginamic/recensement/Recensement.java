package fr.diginamic.recensement;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Recensement {
    private Collection<Ville> villes;
    private Collection<Departement> departements = new HashSet<>();
    private Collection<Region> regions = new HashSet<>();

    public Recensement(Collection<Ville> villes) {
        this.villes = villes;
        System.out.println("Chargement des données, veuillez patienter...");
        this.initializeDepartements();
        this.initializeRegions();
    }

    private void initializeRegions() {
        Set<String> seenRegionNames = new HashSet<>();

//        First loop to instanciate  Region objects
        for (Ville ville : villes) {
            String regionName = ville.getNomRegion();
            if (!seenRegionNames.contains(regionName)) {
                seenRegionNames.add(regionName);
                Region region = new Region(regionName, ville.getCodeRegion());
                regions.add(region);
            }
        }

//        Second loop to setup population
        for (Ville ville : villes){
            for (Region region : regions){
                if (region.getCode() == ville.getCodeRegion()){
                    region.addPopulation(ville.getPopulationTotale());
                }
            }
        }
    }

    private void initializeDepartements() {
        Set<String> seenDepartements = new HashSet<>();

//        First loop to instanciate Departement objects
        for (Ville ville : villes) {
            String codeDepartement = ville.getCodeDepartement();
            if (!seenDepartements.contains(codeDepartement)) {
                seenDepartements.add(codeDepartement);
                Departement departement = new Departement(codeDepartement);
                departements.add(departement);
            }
        }

//        Second loop to setup population
        for (Ville ville : villes){
            for (Departement departement : departements){
                if (departement.getCode().equals(ville.getCodeDepartement())){
                    departement.addPopulation(ville.getPopulationTotale());
                }
            }
        }
    }

    public Collection<Ville> getVilles() {
        return villes;
    }

    public Collection<Departement> getDepartements() {
        return departements;
    }

    public Collection<Region> getRegions() {
        return regions;
    }
}
