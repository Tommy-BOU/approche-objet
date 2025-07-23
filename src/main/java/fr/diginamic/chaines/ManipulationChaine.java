package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

import java.util.Arrays;

public class ManipulationChaine {
    public static void main(String[] args) {
        String chaine = "Durand;Marcel;2 523.5";
        char premierCaractere = chaine.charAt(0);
        System.out.println("Premier caractère: " + premierCaractere);
        System.out.println("Longueur de la chaine : " + chaine.length());
        System.out.println("Index du premier ; : " + chaine.indexOf(';'));

        String nomDeFamille = chaine.substring(0, chaine.indexOf(';'));
        System.out.println("Nom de famille de la personne : " + nomDeFamille);
        System.out.println("Nom de famille de la personne en majuscule : " + nomDeFamille.toUpperCase());
        System.out.println("Nom de famille de la personne en minuscule : " + nomDeFamille.toLowerCase());

        String[] chaineSplit = chaine.split(";");
        System.out.println(Arrays.toString(chaineSplit));

        Salarie salarie = new Salarie(chaineSplit[0], chaineSplit[1], Double.parseDouble(chaineSplit[2].replaceAll("\\s+","")));
        System.out.println(salarie);
    }
}
