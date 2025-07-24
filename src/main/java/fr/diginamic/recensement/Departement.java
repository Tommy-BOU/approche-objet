package fr.diginamic.recensement;

public class Departement {
    private int population;
    private String code;

    public Departement(String code){
        this.code = code;
    }

    public String getCode(){
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
        return "Département : " + this.code + " - Population " + this.population;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass())))
            return false;
        if (!super.equals(obj)) return false;
        Departement compareDep = (Departement) obj;
        return (this.code.equals(compareDep.code)) && (this.population == compareDep.population);
    }
}
