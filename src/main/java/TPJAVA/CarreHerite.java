package TPJAVA;

public class CarreHerite extends Rectangle implements Surfaçable{

    public CarreHerite(Point point, int size) throws DessinHorsLimiteException{
        super (point, size, size);
    }

    public String getType(){
        return "CARRE";
    }

}
