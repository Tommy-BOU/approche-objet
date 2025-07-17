package TPJAVA;

import java.util.Collection;
import java.util.LinkedHashSet;

abstract class Figure {
    Point center;
    String type;

    public Figure(Point p){
        this.center = p;
    }

    public void affiche(){
        System.out.println(this);
    }

    public abstract String getType();

    public abstract String toString();

    public abstract boolean equals(Object obj);

    public abstract Collection<Point> getPoints();

}
