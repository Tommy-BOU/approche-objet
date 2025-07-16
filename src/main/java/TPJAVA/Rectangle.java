package TPJAVA;

public class Rectangle {
    Point center;
    int width;
    int height;

    public Rectangle(Point point, int width, int height){
        this.center = point;
        this.width = width;
        this.height = height;
    }

    public Point getPointBasGauche(){
       return new Point(this.center.getX() - width / 2, this.center.getY() - height / 2);
    }

    public Point getPointBasDroit(){
        return new Point(this.center.getX() + width / 2, this.center.getY() - height / 2);
    }

    public Point getPointHautGauche(){
        return new Point(this.center.getX() - width / 2, this.center.getY() + height / 2);
    }

    public Point getPointHautDroit(){
        return new Point(this.center.getX() + width / 2, this.center.getY() + height / 2);
    }

    public String toString(){
        return "[" + this.getType() + " " + this.getPointHautGauche().toString() + this.getPointHautDroit().toString() + this.getPointBasGauche().toString() + this.getPointBasDroit().toString() + "]";
    }

    protected String getType(){
            return "RECT";
    }

    public void affiche(){
        System.out.println(this);
    }

    protected boolean equals(Rectangle r){
        return r.width == this.width && r.height == this.height && r.center.equals(this.center);
    }

    protected boolean equals(CarreHerite c){
        return c.width == this.width && c.height == this.height && c.center.equals(this.center);
    }

    protected boolean equals(Carre c){
        return c.borderSize == this.width && c.borderSize == this.height && c.center.equals(this.center);
    }

//    Correction Julien
//    @Override
//    public boolean equals(Object obj) {
//        if(!this.getClass().isAssignableFrom(obj.getClass()) && !obj.getClass().isAssignableFrom(this.getClass())) {
//            return false;
//        }
//        Rectangle compareRect = (Rectangle) obj;
//        return getPointBasGauche().equals(compareRect.getPointBasGauche())
//                && getPointBasDroite().equals(compareRect.getPointBasDroite())
//                && getPointHautGauche().equals(compareRect.getPointHautGauche())
//                && getPointHautDroite().equals(compareRect.getPointHautDroite()) ;
//    }

//    Correction prof
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || (!getClass().isAssignableFrom(o.getClass()) && !o.getClass().isAssignableFrom(getClass()) && !Carre.class.isAssignableFrom(o.getClass()))) return false;
//        if (Carre.class.isAssignableFrom(o.getClass())) {
//            Carre r = ((Carre) o);
//            return r.getPointBasDroit().equals(pointBasDroit) && r.getPointBasGauche().equals(pointBasGauche)
//                    && r.getPointHautGauche().equals(pointHautGauche) && r.getPointHautDroit().equals(pointHautDroit);
//        } else {
//            Rectangle r = ((Rectangle) o);
//            return r.pointBasDroit.equals(pointBasDroit) && r.pointBasGauche.equals(pointBasGauche)
//                    && r.pointHautGauche.equals(pointHautGauche) && r.pointHautDroit.equals(pointHautDroit);
//        }
//    }

}
