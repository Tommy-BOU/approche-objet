package TPJAVA;

public class CarreHerite extends Rectangle{

    public CarreHerite(Point point, int size){
        super (point, size, size);
    }

    @Override
    protected String getType() {
        return "CARRE";
    }
}
