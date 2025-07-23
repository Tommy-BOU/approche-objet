package fr.diginamic.maison;

import TPJAVA.Figure;

public abstract class Piece {
    private double superficie;
    private int numeroDEtage;

    public Piece(double superficie, int numeroDEtage) throws IllegalArgumentException{
        if (superficie <= 0){
            throw new IllegalArgumentException("La superficie doit être supérieur à 0");
        }
        if ( numeroDEtage < 0){
            throw new IllegalArgumentException("Le numéro d'étage doit être égal ou supérieur à 0");
        }
        this.superficie = superficie;
        this.numeroDEtage = numeroDEtage;
    }

    public double getSuperficie(){
        return this.superficie;
    }

    public int getNumeroDEtage(){
        return this.numeroDEtage;
    }

}
