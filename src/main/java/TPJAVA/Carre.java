package TPJAVA;

import java.util.Collection;
import java.util.List;

public class Carre extends Figure implements Surfaçable{
    int borderSize;

    private final Point pointHautGauche;
    private final Point pointBasGauche;
    private final Point pointHautDroit;
    private final Point pointBasDroit;

    public Carre(Point point, int size){
        super (point);

        this.borderSize = size;

        this.pointHautGauche = new Point(this.center.getX() - borderSize / 2, this.center.getY() + borderSize / 2);
        this.pointBasGauche = new Point(this.center.getX() - borderSize / 2, this.center.getY() - borderSize / 2);
        this.pointBasDroit = new Point(this.center.getX() + borderSize / 2, this.center.getY() - borderSize / 2);
        this.pointHautDroit = new Point(this.center.getX() + borderSize / 2, this.center.getY() + borderSize / 2);
    }

    public Point getPointBasGauche(){
        return this.pointBasGauche;
    }

    public Point getPointBasDroit(){
        return this.pointBasDroit;
    }

    public Point getPointHautGauche(){
        return this.pointHautGauche;
    }

    public Point getPointHautDroit(){
        return this.pointHautDroit;
    }

    public String getType(){
        return "CARRE";
    }

    public String toString(){
        return "[" + this.getType() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || (!getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(obj.getClass()))) return false;
        Carre c = (Carre) obj;
        return c.borderSize == this.borderSize && c.center.equals(this.center);
    }

    public double surface(){
        return this.borderSize * this.borderSize;
    }

    @Override
    public Collection<Point> getPoints(){
        return List.of(this.pointHautGauche, this.pointHautDroit, this.pointBasGauche, this.pointBasDroit);
    }

    @Override
    public boolean couvre(Point point){
        return point.getX() >= this.pointHautGauche.getX() && point.getX() <= this.pointBasDroit.getX() && point.getY() <= this.pointHautGauche.getY() && point.getY() >= this.pointBasDroit.getY();
    }
}
