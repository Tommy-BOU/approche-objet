package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Carre extends Figure implements Surfacable {
    int borderSize;

    private final Point pointHautGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Carre(Point point, int size) throws DessinHorsLimiteException {
        this(point, Couleur.getCouleurDefaut(),size);
    }

    public Carre(Point point, Couleur color, int size) throws DessinHorsLimiteException {
        super(point, color);

        this.borderSize = size;

        this.pointHautGauche = new Point(this.initialPoint.getX(), this.initialPoint.getY() + borderSize);
        this.pointBasDroit = new Point(this.initialPoint.getX() + borderSize, this.initialPoint.getY());
        this.pointHautDroit = new Point(this.initialPoint.getX() + borderSize, this.initialPoint.getY() + borderSize);

    }

    public Point getPointBasGauche() {
        return this.initialPoint;
    }

    public Point getPointBasDroit() {
        return this.pointBasDroit;
    }

    public Point getPointHautGauche() {
        return this.pointHautGauche;
    }

    public Point getPointHautDroit() {
        return this.pointHautDroit;
    }

    public String getType() {
        return "CARRE";
    }

    public String toString() {
        return "[" + super.toString() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (o == null || (!getClass().isAssignableFrom(o.getClass()) && !Rectangle.class.isAssignableFrom(o.getClass())))
            return false;
        if (Rectangle.class.isAssignableFrom(o.getClass())) {
            Rectangle r = ((Rectangle) o);
            return r.getPointBasDroit().equals(pointBasDroit) && r.getPointHautGauche().equals(pointHautGauche)
                    && r.getPointHautGauche().equals(initialPoint) && r.getPointHautDroit().equals(pointHautDroit);
        } else {
            Carre r = ((Carre) o);
            return r.pointBasDroit.equals(pointBasDroit) && r.pointHautGauche.equals(pointHautGauche)
                    && r.initialPoint.equals(initialPoint) && r.pointHautDroit.equals(pointHautDroit);
        }
    }

    @Override
    public double surface() {
        return this.borderSize * this.borderSize;
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.pointHautGauche, this.pointHautDroit, this.initialPoint, this.pointBasDroit);
    }

    @Override
    public boolean couvre(Point point) {
        return point.getX() >= this.pointHautGauche.getX() && point.getX() <= this.pointBasDroit.getX() && point.getY() <= this.pointHautGauche.getY() && point.getY() >= this.pointBasDroit.getY();
    }
}
