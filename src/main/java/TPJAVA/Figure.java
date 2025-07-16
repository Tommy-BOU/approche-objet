package TPJAVA;

abstract class Figure {
    Point center;
    String type;

    public Figure(Point p){
        this.center = p;
    }

    public void affiche(){
        System.out.println(this);
    }

    public abstract String getType();

    public abstract String toString();

    public abstract boolean equals(Object obj);

}
