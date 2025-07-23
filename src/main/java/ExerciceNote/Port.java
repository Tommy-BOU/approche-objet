package ExerciceNote;

import ExerciceNote.Vehicules.*;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Port {
    Collection<Voiture> voitures = new LinkedHashSet<>();
    Collection<Moto> motos = new LinkedHashSet<>();
    Collection<Maritime> maritimes = new LinkedHashSet<>();

    int maxPlacesVoiture;
    int maxPlacesMotos;
    int maxPlacesMaritimes;

    double reservoir;
    double maxReservoir;

    public Port(int maxPlacesVoiture, int maxPlacesMotos, int maxPlacesMaritimes, double maxReservoir) throws ReservoirInvalideException, ParkingInvalideException {
        if (maxPlacesVoiture < 0 || maxPlacesMotos < 0 || maxPlacesMaritimes < 0) {
            throw new ParkingInvalideException("Les places de parkings doivent être supérieur à 0 lors de l'instanciation d'un port");
        }
        if (maxReservoir <= 0) {
            throw new ReservoirInvalideException("Le reservoir doit être supérieur à 0 lors de l'instanciation d'un port");
        }
        this.maxPlacesVoiture = maxPlacesVoiture;
        this.maxPlacesMotos = maxPlacesMotos;
        this.maxPlacesMaritimes = maxPlacesMaritimes;
        this.reservoir = maxReservoir;
        this.maxReservoir = maxReservoir;
    }

    public Port() throws ReservoirInvalideException, ParkingInvalideException {
        this(10, 5, 20, 500);
    }

    public void garer(Routier vehicule) throws ParkingInvalideException {
        if (vehicule instanceof Voiture) {
            if (voitures.size() < maxPlacesVoiture) {
                voitures.add((Voiture) vehicule);
            } else
                throw new ParkingInvalideException("Il n'y a plus de place pour garer de voiture - Max " + this.maxPlacesVoiture);
        } else if (vehicule instanceof Moto) {
            if (motos.size() < maxPlacesMotos) {
                motos.add((Moto) vehicule);
            } else
                throw new ParkingInvalideException("Il n'y a plus de place pour garer de moto - Max " + this.maxPlacesMotos);
        }
    }

    public void amarer(Maritime vehicule) throws ParkingInvalideException {
        if (maritimes.size() < maxPlacesMaritimes) {
            maritimes.add(vehicule);
        } else
            throw new ParkingInvalideException("Il n'y a plus de place pour garer de véhicule maritime - Max " + this.maxPlacesMaritimes);
    }

    public void sortir(Vehicule vehicule) {
        if (vehicule instanceof Voiture) {
            voitures.remove(vehicule);
        } else if (vehicule instanceof Moto) {
            motos.remove(vehicule);
        } else if (vehicule instanceof Maritime) {
            maritimes.remove(vehicule);
        }
    }

    public double getReservoir() {
        return this.reservoir;
    }

    public double getReservoirMax() {
        return this.maxReservoir;
    }

    public void obtenirCarburant(AMoteur vehicule) throws ReservoirInvalideException {
        if ((this.reservoir - vehicule.getReservoir()) < 0) {
            throw new ReservoirInvalideException("Le port n'a pas assez de carburant pour effectuer le plein - Reservoir à " + this.getReservoir() + "L");
        }
        this.reservoir -= vehicule.getReservoir();
    }

    public void remplirReservoir() {
        this.reservoir = this.maxReservoir;
    }

    public String getState() {
        return "Il y a " + voitures.size() + " voitures, " + motos.size() + " motos et " + maritimes.size() + " bateaux dans le port. Il lui reste encore " + this.reservoir + "L d'essence.";
    }

    public String toString(){
        return this.getState();
    }
}
