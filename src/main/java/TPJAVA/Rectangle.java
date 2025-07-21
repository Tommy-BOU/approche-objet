package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfaçable {
    int width;
    int height;

    private final Point pointHautGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Rectangle(Point point, int width, int height) throws DessinHorsLimiteException {
        this(point, Couleur.getCouleurDefaut(), width, height);
    }

    public Rectangle(Point point, Couleur color, int width, int height) throws DessinHorsLimiteException {
        super(point, color);
        this.width = width;
        this.height = height;

        this.pointHautGauche = new Point(this.initialPoint.getX(), this.initialPoint.getY() + height);
        this.pointBasDroit = new Point(this.initialPoint.getX() + width, this.initialPoint.getY());
        this.pointHautDroit = new Point(this.initialPoint.getX() + width, this.initialPoint.getY() + height);
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
        return "RECT";
    }

    public String toString() {
        return "[" + super.toString() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (o == null || (!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(o.getClass())))
            return false;
        if (Carre.class.isAssignableFrom(o.getClass())) {
            Carre r = ((Carre) o);
            return r.getPointBasDroit().equals(pointBasDroit) && r.getPointBasGauche().equals(initialPoint)
                    && r.getPointHautGauche().equals(pointHautGauche) && r.getPointHautDroit().equals(pointHautDroit) && r.getColor() == this.color;
        } else {
            Rectangle r = ((Rectangle) o);
            return r.pointBasDroit.equals(pointBasDroit) && r.initialPoint.equals(initialPoint)
                    && r.pointHautGauche.equals(pointHautGauche) && r.pointHautDroit.equals(pointHautDroit) && r.getColor() == this.color;
        }
    }

    @Override
    public double surface() {
        return this.width * this.height;
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
