package fr.diginamic.combat;

public class Goblin extends Enemy{
    public Goblin(int hitPoints, int strength) {
        super(hitPoints, strength, 2);
    }

    public String toString(){
        return "Gobelin";
    }
}
