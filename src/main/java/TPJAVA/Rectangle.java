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
}
