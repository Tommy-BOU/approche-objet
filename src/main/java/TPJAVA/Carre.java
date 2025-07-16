package TPJAVA;

public class Carre {
    Point center;
    int borderSize;
    public Carre(Point point, int size){
        this.center = point;
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

    public String toString(){
        return "[CARRE " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    public void affiche(){
        System.out.println(this);
    }
}
