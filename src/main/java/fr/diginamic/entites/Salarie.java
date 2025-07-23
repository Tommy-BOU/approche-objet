package fr.diginamic.entites;

public class Salarie {
    String nom;
    String prenom;
    double salaire;

    public Salarie(String nom, String prenom, double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public String toString(){
        return "Salarie : " + this.nom + " " + this.prenom + " - Salaire : " + this.salaire;
    }
}
