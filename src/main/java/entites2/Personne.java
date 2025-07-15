package entites2;

import entites.AdressePostale;

public class Personne {
    public String nom;
    public String prenom;
    public AdressePostale adressePostale;

    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(String nom, String prenom, AdressePostale adressePostale){
        this.nom = nom;
        this.prenom = prenom;
        this.adressePostale = adressePostale;
    }

    public void Presentation()
    {
        System.out.println("Bonjour, je m'appelle " + prenom + " " + nom.toUpperCase());
    }

    public void setNom(String newNom){
        this.nom = newNom;
    }

    public void setPrenom(String newPrenom){
        this.prenom = newPrenom;
    }

    public void setAdresse(AdressePostale newAdressePostale){
        this.adressePostale = newAdressePostale;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public AdressePostale getAdresse(){
        return this.adressePostale;
    }


}
