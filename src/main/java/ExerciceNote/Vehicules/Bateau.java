package ExerciceNote.Vehicules;

import ExerciceNote.Port;
import ExerciceNote.ReservoirInvalideException;

public class Bateau extends Maritime implements AMoteur{
    double reservoir = 0;

    public Bateau(String marque, String modele, String numImmat)throws ReservoirInvalideException {
        this(marque, modele, numImmat, 200);
    }

    public Bateau(String marque, String modele, String numImmat, double reservoir) throws ReservoirInvalideException {
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
        return "Bateau " + super.toString();
    }
}
