package TPJAVA;

public class Carre extends Figure{
    Point center;
    int borderSize;

    public Carre(Point point, int size){
        super (point);
        this.borderSize = size;
    }

    public Point getPointBasGauche(){
        return new Point(this.center.getX() - borderSize / 2, this.center.getY() - borderSize / 2);
    }

    public Point getPointBasDroit(){
        return new Point(this.center.getX() + borderSize / 2, this.center.getY() - borderSize / 2);
    }

    public Point getPointHautGauche(){
        return new Point(this.center.getX() - borderSize / 2, this.center.getY() + borderSize / 2);
    }

    public Point getPointHautDroit(){
        return new Point(this.center.getX() + borderSize / 2, this.center.getY() + borderSize / 2);
    }

    public String getType(){
        return "CARRE";
    }

    public String toString(){
        return "[" + this.getType() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    public boolean equals(Object obj){
        Carre c = (Carre) obj;
        return c.borderSize == this.borderSize && c.center.equals(this.center);
    }
}
