package TPJAVA;

public class Point {

    private final static int INIT_X = 25;
    private final static int INIT_Y = 25;

    public int x;
    public int y;

    public Point(int x, int y) throws DessinHorsLimiteException {
        if (x < 0 || x > 99 || y < 0 || y > 99){
            throw new DessinHorsLimiteException("Le point ne respecte par la limite ([0:99]) : Point [" + x + ";" + y +"]");
        }
        this.x = x;
        this.y = y;
    }

    public Point() throws DessinHorsLimiteException{
        this(INIT_X, INIT_Y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getINIT_X() {
        return INIT_X;
    }

    public int getINIT_Y() {
        return INIT_Y;
    }

    public String toString() {
        return "[" + x + ";" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !getClass().isAssignableFrom(obj.getClass())) return false;
        Point comparePoint = ((Point) obj);
        return (x == comparePoint.x) && (y == comparePoint.y);
    }

    public double distance(Point p) {
        int difX = Math.abs(this.getX() - p.getX());
        int difY = Math.abs(this.getY() - p.getY());
        return Math.sqrt((difX * difX) + (difY * difY));
    }
}
