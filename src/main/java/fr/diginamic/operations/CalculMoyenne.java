package fr.diginamic.operations;

import java.util.ArrayList;
import java.util.Collection;

public class CalculMoyenne {
    Collection<Double> valeurs = new ArrayList<>();

    public void ajout(double val){
        valeurs.add(val);
    }

    public double calcul(){
        double total = 0;
        for (double d : valeurs){
            total += d;
        }

        return total / valeurs.size();
    }
}
