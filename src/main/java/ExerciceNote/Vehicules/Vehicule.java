package ExerciceNote.Vehicules;

public abstract class Vehicule {
    String marque;
    String modele;
    String numImmat;

    public Vehicule(String marque, String modele, String numImmat){
        this.marque = marque;
        this.modele = modele;
        this.numImmat = numImmat;
    }

    public String getMarque(){
        return this.marque;
    }

    public String getModele(){
        return this.modele;
    }

    public String getNumImmat(){
        return this.numImmat;
    }

    public String toString(){
        return "N° : " + this.getNumImmat() + ", Modèle : " + this.getMarque() + " " + this.getModele();
    }
}
