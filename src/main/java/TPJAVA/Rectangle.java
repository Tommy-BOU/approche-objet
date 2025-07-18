package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfaçable {
    int width;
    int height;

    private final Point pointHautGauche;
    private final Point pointBasGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Rectangle(Point point, int width, int height) {
        super(point);
        this.width = width;
        this.height = height;

        this.pointHautGauche = new Point(this.center.getX() - width / 2, this.center.getY() + height / 2);
        this.pointBasGauche = new Point(this.center.getX() - width / 2, this.center.getY() - height / 2);
        this.pointBasDroit = new Point(this.center.getX() + width / 2, this.center.getY() - height / 2);
        this.pointHautDroit = new Point(this.center.getX() + width / 2, this.center.getY() + height / 2);
    }

    public Point getPointBasGauche() {
        return this.pointBasGauche;
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
        return "[" + this.getType() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(o.getClass())))
            return false;
        if (Carre.class.isAssignableFrom(o.getClass())) {
            Carre r = ((Carre) o);
            return r.getPointBasDroit().equals(pointBasDroit) && r.getPointBasGauche().equals(pointBasGauche)
                    && r.getPointHautGauche().equals(pointHautGauche) && r.getPointHautDroit().equals(pointHautDroit);
        } else {
            Rectangle r = ((Rectangle) o);
            return r.pointBasDroit.equals(pointBasDroit) && r.pointBasGauche.equals(pointBasGauche)
                    && r.pointHautGauche.equals(pointHautGauche) && r.pointHautDroit.equals(pointHautDroit);
        }
    }

    @Override
    public double surface() {
        return this.width * this.height;
    }

    @Override
    public Collection<Point> getPoints() {
        return List.of(this.pointHautGauche, this.pointHautDroit, this.pointBasGauche, this.pointBasDroit);
    }


    @Override
    public boolean couvre(Point point) {
        return point.getX() >= this.pointHautGauche.getX() && point.getX() <= this.pointBasDroit.getX() && point.getY() <= this.pointHautGauche.getY() && point.getY() >= this.pointBasDroit.getY();
    }

}
