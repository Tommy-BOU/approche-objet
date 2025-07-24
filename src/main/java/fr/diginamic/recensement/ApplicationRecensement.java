package fr.diginamic.recensement;

import java.util.Collection;

public class ApplicationRecensement {
    public static void main(String[] args) {
        Collection<Ville> villes = LireFichierAvecInstantciation.readFile("recensement.csv");
        Recensement recensement = new Recensement(villes);
        Application app = new Application(recensement);
        app.start();
    }

}
