package fr.diginamic.maison;

import TPJAVA.Carre;
import TPJAVA.Rond;

public class SalleDeBain extends Piece{
    public SalleDeBain(double superficie, int numeroDetage){
        super(superficie, numeroDetage);
    }

    public String toString(){
        return "Salle de bain";
    }
}
