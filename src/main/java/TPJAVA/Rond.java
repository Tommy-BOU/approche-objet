package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable {
    int radius;

    public Rond(Point point, int radius) {
        this(point, Couleur.getCouleurDefaut(), radius);
    }

    public Rond(Point point, Couleur color, int radius) {
        super(point, color);
        this.radius = radius;
    }

    public String getType() {
        return "ROND";
    }

    public String toString() {
        return "[" + super.toString() + " " + this.initialPoint.toString() + " , " + this.radius + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass())))
            return false;
        Rond compareRond = (Rond) obj;
        return (this.radius == compareRond.radius) && (this.initialPoint == compareRond.initialPoint) && compareRond.getColor() == this.color;
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.initialPoint);
    }

    @Override
    public double surface() {
        return Math.PI * (this.radius * this.radius);
    }

    @Override
    public boolean couvre(Point point) {
        double distance = this.initialPoint.distance(point);
        return distance <= this.radius;
    }

}
