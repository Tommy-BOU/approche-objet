package TPJAVA;

public class Rond extends Figure{
    int radius;

    public Rond(Point point, int radius){
        super (point);
        this.radius = radius;
    }

    public String getType(){
        return "ROND";
    }

    public String toString(){
        return "[" + this.getType() + " " + this.center.toString() + " , " + this.radius +"]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        Rond compareRond = (Rond) obj;
        return (this.radius == compareRond.radius) && (this.center == compareRond.center);
    }

}
