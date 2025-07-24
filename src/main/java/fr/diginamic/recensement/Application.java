package fr.diginamic.recensement;

import fr.diginamic.Utils;
import fr.diginamic.recensement.services.*;

import java.util.Scanner;

public class Application {
    Scanner scanner = new Scanner(System.in);
    Recensement recensement;

    public Application(Recensement recensement){
        this.recensement = recensement;
    }

    public void start(){
        this.displayMenu();
    }

    public void displayMenu(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("----------------");
        System.out.println("Choisissez une option :");
        System.out.println("1 - Population d'une ville donnée.");
        System.out.println("2 - Population d'un département donné.");
        System.out.println("3 - Population d'une région donnée.");
        System.out.println("4 - Afficher les 10 régions les plus peuplées.");
        System.out.println("5 - Afficher les 10 départements les plus peuplés.");
        System.out.println("6 - Afficher les 10 villes les plus peuplées d'un département.");
        System.out.println("7 - Afficher les 10 villes les plus peuplées d'une région.");
        System.out.println("8 - Afficher les 10 villes les plus peuplées de France.");
        System.out.println("9 - Sortir");

        String userInput = scanner.nextLine();
        int userChoice = Utils.inputToInt(userInput);

        switch (userChoice) {
            case 1:
                RecherchePopulationVille recherchePopVille = new RecherchePopulationVille();
                recherchePopVille.traiter(recensement, scanner);
                displayMenu();
                break;
            case 2:
                RecherchePopulationDepartement recherchePopDep = new RecherchePopulationDepartement();
                recherchePopDep.traiter(recensement, scanner);
                displayMenu();
                break;
            case 3:
                RecherchePopulationRegion recherchePopRegion = new RecherchePopulationRegion();
                recherchePopRegion.traiter(recensement, scanner);
                displayMenu();
                break;
            case 4:
                RechercheRegionsPlusPeuplees rechercheRegionPlusPop = new RechercheRegionsPlusPeuplees();
                rechercheRegionPlusPop.traiter(recensement, scanner);
                displayMenu();
                break;
            case 5:
                RechercheDepartementsPlusPeuples rechercheDepPlusPop = new RechercheDepartementsPlusPeuples();
                rechercheDepPlusPop.traiter(recensement, scanner);
                displayMenu();
                break;
            case 6:
                RechercheVillesPlusPeupleesDepartement rechercheVillesPlusPopDep = new RechercheVillesPlusPeupleesDepartement();
                rechercheVillesPlusPopDep.traiter(recensement, scanner);
                displayMenu();
                break;
            case 7:
                RechercheVillesPlusPeupleesRegion rechercheVillesPlusPopReg = new RechercheVillesPlusPeupleesRegion();
                rechercheVillesPlusPopReg.traiter(recensement, scanner);
                displayMenu();
                break;
            case 8:
                RechercheVillesPlusPeupleesFrance rechercheVillesPlusPopFrance = new RechercheVillesPlusPeupleesFrance();
                rechercheVillesPlusPopFrance.traiter(recensement, scanner);
                displayMenu();
                break;
            case 9:
                break;
            default:
                displayMenu();
        }
    }
}
