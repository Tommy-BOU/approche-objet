package fr.diginamic.recensement;

public class Ville {
    private String nom;
    private String codeDepartement;
    private String nomRegion;
    private int populationTotale;
    private int codeCommune;
    private int codeRegion;

    public Ville(String nom, String codeDepartement, String nomRegion, int populationTotale, int codeCommune, int codeRegion) {
        this.nom = nom;
        this.codeDepartement = codeDepartement;
        this.nomRegion = nomRegion;
        this.populationTotale = populationTotale;
        this.codeCommune = codeCommune;
        this.codeRegion = codeRegion;
    }

    public String getNom(){
        return this.nom;
    }

    public String getCodeDepartement(){
        return this.codeDepartement;
    }

    public String getNomRegion(){
        return this.nomRegion;
    }

    public int getPopulationTotale(){
        return this.populationTotale;
    }

    public int getCodeCommune(){
        return this.codeCommune;
    }

    public int getCodeRegion(){
        return this.codeRegion;
    }

    public String toString() {
        return "Ville : " + this.nom + " - Population : " + this.populationTotale + " - Departement : " + this.codeDepartement + " - Région : " + this.nomRegion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass())))
            return false;
        if (!super.equals(obj)) return false;
        Ville compareVille = (Ville) obj;
        return (this.nom.equals(compareVille.nom)) && (this.codeDepartement.equals(compareVille.codeDepartement)) && (compareVille.nomRegion.equals(this.nomRegion)) && (this.populationTotale == compareVille.populationTotale) && (this.codeCommune == compareVille.codeCommune) && (this.codeRegion == compareVille.codeRegion);
    }
}
