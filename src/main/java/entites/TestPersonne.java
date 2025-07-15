package entites;

import entites2.Personne;

public class TestPersonne {
    public static void main(String[] args) {
        Personne per1 = new Personne();
        Personne per2 = new Personne();

        per1.nom = "Dupont";
        per1.prenom = "Jean";
        per1.adressePostale = new AdressePostale();

        per2.nom = "Dujean";
        per2.prenom = "Pont";
        per2.adressePostale = new AdressePostale();
    }
}
