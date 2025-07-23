package ExerciceNote.Vehicules;

import ExerciceNote.Port;
import ExerciceNote.ReservoirInvalideException;

public class Moto extends Routier implements AMoteur{
    double reservoir = 0;

    public Moto(String marque, String modele, String numImmat) throws ReservoirInvalideException {
        this(marque, modele, numImmat, 20);
    }

    public Moto(String marque, String modele, String numImmat, double reservoir) throws ReservoirInvalideException {
        super(marque, modele, numImmat);
        if (reservoir <= 0) {
            throw new ReservoirInvalideException(this + "a un montant reservoir invalide - Le réservoir doit être supérieur à 0");
        } else {
            this.reservoir = reservoir;
        }
    }

    @Override
    public void remplirReservoir(Port port) throws ReservoirInvalideException{
        port.obtenirCarburant(this);
    }

    @Override
    public double getReservoir(){
        return reservoir;
    }

    public String toString(){
        return "Moto " + super.toString();
    }
}
