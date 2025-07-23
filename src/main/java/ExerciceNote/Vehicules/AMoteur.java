package ExerciceNote.Vehicules;

import ExerciceNote.Port;
import ExerciceNote.ReservoirInvalideException;

public interface AMoteur {
    void remplirReservoir(Port port) throws ReservoirInvalideException;
    double getReservoir();
}
