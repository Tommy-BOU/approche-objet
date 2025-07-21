package TPJAVA;

public class CarreHerite extends Rectangle implements Surfacable {

    public CarreHerite(Point point, int size) throws DessinHorsLimiteException{
        super (point, size, size);
    }

    public CarreHerite(Point point, Couleur color, int size) throws DessinHorsLimiteException{
        super (point, color, size, size);
    }

    public String getType(){
        return "CARRE";
    }

}
