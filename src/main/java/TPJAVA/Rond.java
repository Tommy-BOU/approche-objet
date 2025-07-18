package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfaçable {
    int radius;

    public Rond(Point point, int radius) {
        super(point);
        this.radius = radius;
    }

    public String getType() {
        return "ROND";
    }

    public String toString() {
        return "[" + this.getType() + " " + this.center.toString() + " , " + this.radius + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass())))
            return false;
        Rond compareRond = (Rond) obj;
        return (this.radius == compareRond.radius) && (this.center == compareRond.center);
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.center);
    }

    @Override
    public double surface() {
        return Math.PI * (this.radius * this.radius);
    }

    @Override
    public boolean couvre(Point point) {
        double distance = this.center.distance(point);
        return distance <= this.radius;
    }

}
