package ExerciceNote.Vehicules;

import ExerciceNote.ReservoirInvalideException;
import ExerciceNote.Port;

public class Voiture extends Routier implements AMoteur {
    double reservoir;

    public Voiture(String marque, String modele, String numImmat) throws ReservoirInvalideException {
        this(marque, modele, numImmat, 50);
    }

    public Voiture(String marque, String modele, String numImmat, double reservoir) throws ReservoirInvalideException {
        super(marque, modele, numImmat);
        if (reservoir <= 0) {
            throw new ReservoirInvalideException(this + "a un montant reservoir invalide - Le reservoir doit être supérieur à 0");
        } else {
            this.reservoir = reservoir;
        }
    }

    @Override
    public void remplirReservoir(Port port) throws ReservoirInvalideException{
        port.obtenirCarburant(this);
    }

    @Override
    public double getReservoir() {
        return reservoir;
    }

    public String toString() {
        return "Voiture " + super.toString();
    }
}
