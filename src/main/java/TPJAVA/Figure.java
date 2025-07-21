package TPJAVA;

import java.util.Collection;

public abstract class Figure implements Comparable<Figure> {
    protected Point initialPoint;
    Couleur color;
    private static final Point origine;

    static {
        try {
            origine = new Point();
        } catch (DessinHorsLimiteException e) {
            throw new RuntimeException(e);
        }
    }

    public Figure(Point p, Couleur color) {
        this.initialPoint = p;
        this.color = color;
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

    public Couleur getColor(){
        return this.color;
    }

    public abstract boolean couvre(Point point);

    public abstract String getType();

    public String toString(){
        return getType() + " " + this.color;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof Figure)) return false;
        return (initialPoint == ((Figure) obj).initialPoint && color == ((Figure) obj).getColor());
    }

    public abstract double surface();

    public abstract Collection<Point> getPoints();

}
