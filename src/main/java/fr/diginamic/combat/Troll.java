package fr.diginamic.combat;

public class Troll extends Enemy{
    public Troll(int hitPoints, int strength) {
        super(hitPoints, strength, 5);
    }

    public String toString(){
        return "Troll";
    }
}
