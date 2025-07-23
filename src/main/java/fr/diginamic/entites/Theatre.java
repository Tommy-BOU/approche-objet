package fr.diginamic.entites;

public class Theatre {
    String nom;
    int capaciteMax;
    int clientsInscrits;
    double recette;

    public Theatre(String nom, int capaciteMax, int clientsInscrits, double recette){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.clientsInscrits = clientsInscrits;
        this.recette = recette;
    }

    public void inscrire(int nbrClients, double prixPlace) throws Error{
        if ((clientsInscrits + nbrClients) <= capaciteMax){
            clientsInscrits += nbrClients;
            recette += prixPlace * nbrClients;
        } else {
            throw new Error("Impossible d'inscrire le nombre de clients, pas assez de places (Theatre plein a " + clientsInscrits + " / " + capaciteMax + " clients)");
        }
    }
}
