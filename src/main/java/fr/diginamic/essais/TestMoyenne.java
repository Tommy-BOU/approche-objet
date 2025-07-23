package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    public static void main(String[] args) {
        CalculMoyenne calc = new CalculMoyenne();

        calc.ajout(50);
        calc.ajout(100);
        calc.ajout(200);
        calc.ajout(50);

        System.out.println("Moyenne des valeurs du tableau : " + calc.calcul());
    }
}
