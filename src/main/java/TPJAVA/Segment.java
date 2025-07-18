package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Segment extends Figure {

    public int length;
    public boolean horizontal;
    Point pointDebut;
    Point pointFin;

    public Segment(Point point, int length, boolean horizontal) {
        super(point);
        this.length = length;
        this.horizontal = horizontal;

        if (horizontal) {
            this.pointDebut = new Point((this.center.getX() - this.length / 2), this.center.getY());
            this.pointFin = new Point((this.center.getX() + this.length / 2), this.center.getY());
        } else {
            this.pointDebut = new Point((this.center.getX()), (this.center.getY() - this.length / 2));
            this.pointFin = new Point((this.center.getX()), (this.center.getY() + this.length / 2));
        }
    }

    public String getType() {
        return "SEGMENT";
    }


    public String toString() {
        return "[" + this.getType() + " " + this.pointDebut.toString() + " à " + this.pointFin.toString() + "," + (this.horizontal ? "Horizontal" : "Vertical") + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass())))
            return false;
        Segment s = (Segment) obj;
        return this.pointDebut.equals(s.pointDebut) && this.pointFin.equals(s.pointFin);
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.pointDebut, this.pointFin);
    }

    @Override
    public double surface() {
        return 0;
    }

    @Override
    public boolean couvre(Point point) {
        if (this.horizontal) {
            return point.getX() >= this.pointDebut.getX() && point.getX() <= this.pointFin.getX() && point.getY() == this.center.getY();
        } else {
            return point.getY() >= this.pointDebut.getY() && point.getY() <= this.pointFin.getY() && point.getX() == this.center.getX();
        }
    }

}
