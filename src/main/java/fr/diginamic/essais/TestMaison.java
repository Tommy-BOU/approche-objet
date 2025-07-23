package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    public static void main(String[] args) {
        Maison maison = new Maison();

        Salon salon = new Salon(50, 0);
        SalleDeBain sdb = new SalleDeBain(20, 1);
        WC wc = new WC(10, 2);
        Chambre chambre1 = new Chambre(30, 1);
        Chambre chambre2 = new Chambre(35, 1);
        Cuisine cuisine = new Cuisine(40, 0);

        maison.ajouterPiece(salon);
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre1);
        maison.ajouterPiece(chambre2);
        maison.ajouterPiece(cuisine);

//        maison.ajouterPiece(new Cuisine(-5, -10));
//        maison.ajouterPiece(null);

        System.out.println(maison);
        System.out.println("Superficie de la maison : " + maison.getTotalSuperficie());
        System.out.println("Superficie du 1er étage : " + maison.getEtageSuperficie(1));
        System.out.println("Superficie des chambres : " + maison.getSuperficieByRoomType("Chambre"));
        System.out.println("Nombre de chambres : " + maison.getNumberOfRoomByType("Chambre"));
    }
}
