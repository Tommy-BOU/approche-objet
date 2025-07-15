package JAVA10;

public class TestClasses {
    public static void main(String[] args) {
        Point testPoint = new Point(10,10);
        Rond testRond = new Rond(testPoint, 10);
        Rectangle testRectangle = new Rectangle(testPoint, 10,10);


        testRond.affiche();

        testRectangle.affiche();
    }
}
