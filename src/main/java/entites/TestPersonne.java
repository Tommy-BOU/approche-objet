package entites;

import entites2.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne per1 = new Personne("Dupont", "Jean", new AdressePostale(65, "Impasse du peuple", 46531, "Laville"));
        Personne per2 = new Personne("Dujean","Pont", new AdressePostale(945, "Chemin de traverse", 666666, "Poudlard"));

//        per1.nom = "Dupont";
//        per1.prenom = "Jean";
//        per1.adressePostale = new AdressePostale();

//        per2.nom = "Dujean";
//        per2.prenom = "Pont";
//        per2.adressePostale = new AdressePostale();
    }
}
