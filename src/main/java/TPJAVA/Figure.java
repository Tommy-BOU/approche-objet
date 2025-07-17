package TPJAVA;

import java.util.Collection;

public abstract class Figure {
    Point center;

    public Figure(Point p){
        this.center = p;
    }

    public void affiche(){
        System.out.println(this);
    }

    static public double getDistance(Point p1, Point p2) {
        int difX = Math.abs(p1.getX() - p2.getX());
        int difY = Math.abs(p1.getY() - p2.getY());
        return Math.sqrt((difX * difX) + (difY * difY));
    }

    public abstract boolean couvre(Point point);

    public abstract String getType();

    public abstract String toString();

    public abstract boolean equals(Object obj);

    public abstract Collection<Point> getPoints();

}
