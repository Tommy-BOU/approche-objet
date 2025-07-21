package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Segment extends Figure {

    public int length;
    public boolean horizontal;

    Point pointFin;

    public Segment(Point point, int length, boolean horizontal) throws DessinHorsLimiteException {
        this(point, Couleur.getCouleurDefaut(), length, horizontal);
    }

    public Segment(Point point, Couleur color, int length, boolean horizontal) throws DessinHorsLimiteException {
        super(point, color);
        this.length = length;
        this.horizontal = horizontal;

        pointFin = new Point(initialPoint.getX() + (horizontal ? length : 0), initialPoint.getY() + (horizontal ? 0 : length));
    }

    public String getType() {
        return "SEGMENT";
    }


    public String toString() {
        return "[" + super.toString() + " " + this.initialPoint.toString() + " à " + this.pointFin.toString() + "," + (this.horizontal ? "Horizontal" : "Vertical") + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass())))
            return false;
        Segment s = (Segment) obj;
        return this.initialPoint.equals(s.initialPoint) && this.pointFin.equals(s.pointFin) && s.getColor() == this.color;
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.initialPoint, this.pointFin);
    }

    @Override
    public double surface() {
        return 0;
    }

    @Override
    public boolean couvre(Point point) {
        if (this.horizontal) {
            return point.getX() >= this.initialPoint.getX() && point.getX() <= this.pointFin.getX() && point.getY() == this.initialPoint.getY();
        } else {
            return point.getY() >= this.initialPoint.getY() && point.getY() <= this.pointFin.getY() && point.getX() == this.initialPoint.getX();
        }
    }

}
