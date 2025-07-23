package fr.diginamic.combat;

import java.util.Random;

public abstract class Character {
    private int hitPoints;
    private int strength;

    public Character (int hitPoints, int strength){
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public int getHitPoints(){
        return this.hitPoints;
    }

    public void setHitPoints(int value){
        this.hitPoints = value;
    }

    public void heal(int amount){
        this.hitPoints += amount;
    }

    public void takeDamage(int amount){
        this.hitPoints -= amount;
    }

    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int value){
        this.strength = value;
    }

    public String combatIntro(){
        return "Un " + this + " approche";
    }
}
