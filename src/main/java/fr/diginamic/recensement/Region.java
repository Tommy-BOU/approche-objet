package fr.diginamic.recensement;

public class Region {
    private String nom;
    private int population;
    private int code;

    public Region(String nom, int code){
        this.nom = nom;
        this.code = code;
    }

    public String getNom(){
        return this.nom;
    }

    public int getCode(){
        return this.code;
    }

    public int getPopulation(){
        return this.population;
    }

    public void setPopulation(int value){
        this.population = value;
    }

    public void addPopulation(int value){
        this.population += value;
    }

    @Override
    public String toString(){
        return "Région : " + this.nom + " - Population " + this.population;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass())))
            return false;
        if (!super.equals(obj)) return false;
        Region compareRegion = (Region) obj;
        return (this.nom.equals(compareRegion.nom)) && (this.code == compareRegion.code)  &&  (this.population == compareRegion.population);
    }
}
