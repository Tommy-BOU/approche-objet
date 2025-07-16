package TPJAVA;

public class CarreHerite extends Rectangle{

    public CarreHerite(Point point, int size){
        super (point, size, size);
    }

    public String getType(){
        return "CARRE";
    }

}
