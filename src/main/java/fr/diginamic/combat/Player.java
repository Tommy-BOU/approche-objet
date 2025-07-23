package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.Collection;

public class Player extends Character{
    private int score;
    int numOfHealthPotions;
    int numOfMinorAttackPotion;
    int numOfMajorAttackPotion;
    private final int baseStrength;

    int turnsBoost;

    public Player(int hitPoints, int strength){
        super(hitPoints, strength);
        this.baseStrength = strength;
        this.score = 0;
        this.numOfHealthPotions = 1;
        this.numOfMajorAttackPotion = 1;
        this.numOfMinorAttackPotion = 1;
        this.turnsBoost = 0;
    }

    public Player(){
        this(12, 20);
    }

    public int getScore(){
        return this.score;
    }

    public void addScore(int value){
        this.score += value;
    }

    public void boostStrength(int amount, int turns){
        this.setStrength(this.getStrength() + amount);
        this.turnsBoost = Math.max(turnsBoost,turns);
    }

    public void resetStrength(){
        this.setStrength(this.baseStrength);
    }
}
