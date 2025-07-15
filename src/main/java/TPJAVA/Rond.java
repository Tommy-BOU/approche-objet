package TPJAVA;

public class Rond {
    Point center;
    int radius;

    public Rond(Point point, int radius){
        this.center = point;
        this.radius = radius;
    }

    public String toString(){
        return "[ROND " + this.center.toString() + " , " + this.radius +"]";
    }

    public void affiche(){
        System.out.println(this);
    }
}
