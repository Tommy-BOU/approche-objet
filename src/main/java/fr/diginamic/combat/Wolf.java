package fr.diginamic.combat;

public class Wolf extends Enemy{

    public Wolf(int hitPoints, int strength) {
        super(hitPoints, strength, 1);
    }

    public String toString(){
        return "Loup";
    }
}
