package TPJAVA;

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
        return "[" + this.pointDebut.toString() + " à " + this.pointFin.toString() + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Segment s = (Segment) obj;
        return ((this.length == s.length) && (this.horizontal == s.horizontal) && (this.center.equals(s.center)));
    }

    @Override
    public Point[] getPoints() {
        return new Point[] {this.pointDebut, this.pointFin};
    }

}
