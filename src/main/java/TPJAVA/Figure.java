package TPJAVA;

import java.util.Collection;

public abstract class Figure implements Comparable<Figure> {
    Point center;
    private static Point origine = new Point();

    public Figure(Point p) {
        this.center = p;
    }

    public void affiche() {
        System.out.println(this);
    }

    public double distanceOrigine() {
        double closestDistance = Double.MAX_VALUE;
        for (Point point : this.getPoints()) {
            if (origine.distance(point) < closestDistance) {
                closestDistance = origine.distance(point);
            }
        }
        return closestDistance;
    }

    @Override
    public int compareTo(Figure figure) {
        if (this.distanceOrigine() < figure.distanceOrigine()) {
            return -1;
        } else if (this.distanceOrigine() > figure.distanceOrigine()) {
            return 1;
        } else {
            return 0;
        }
    }

    public abstract boolean couvre(Point point);

    public abstract String getType();

    public abstract String toString();

    public abstract boolean equals(Object obj);

    public abstract double surface();

    public abstract Collection<Point> getPoints();

}
