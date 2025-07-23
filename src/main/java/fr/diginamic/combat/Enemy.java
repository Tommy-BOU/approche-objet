package fr.diginamic.combat;

public abstract class Enemy extends Character{
    private final int scoreValue;

    public Enemy(int hitPoints, int strength, int scoreValue) {
        super(hitPoints, strength);
        this.scoreValue = scoreValue;
    }

    public int getScoreValue(){
        return this.scoreValue;
    }
}
