package TPJAVA;

public class TestClasses {
    public static void main(String[] args) {
        Point testPoint = new Point(10,10);
        Rond testRond = new Rond(testPoint, 10);
        Rectangle testRectangle = new Rectangle(testPoint, 10,10);


        testRond.affiche();

        testRectangle.affiche();

        FigureUtil fig = new FigureUtil();
        Rond testRond2 = fig.getRandomRond();
        Rectangle testRectangle2 = fig.getRandomRectangle();

        testRond2.affiche();
        testRectangle2.affiche();

        Carre testCarre = new Carre(testPoint, 10);
        CarreHerite testCarreHerite = new CarreHerite(testPoint, 10);

        testCarre.affiche();
        testCarreHerite.affiche();

        Carre testCarre2 = fig.getRandomCarre();
        CarreHerite testCarreHerite2 = fig.getRandomCarreHerite();

        testCarre2.affiche();
        testCarreHerite2.affiche();

        Point testPoint3 = new Point(10,10);
        Carre testCarre3 = new Carre(testPoint, 10);
        CarreHerite testCarreHerite3 = new CarreHerite(testPoint, 10);

        System.out.println("testPoint3.equals(testPoint)) : " + testPoint3.equals(testPoint));
        System.out.println("testCarre3.equals(testCarre)) : " + testCarre3.equals(testCarre));
        System.out.println("testCarreHerite3.equals(testCarreHerite)) : " + testCarreHerite3.equals(testCarreHerite));

        Figure testFigure = fig.getRandomFigure();

        testFigure.affiche();

        Surfaçable testSurfaçable = fig.getRandomSurfaçable();

        System.out.println(testSurfaçable.surface());

        int index = 0;
        for (Point point : fig.getPoints(fig.genere(5))){
            System.out.println("Point " + index + " " + point.toString());
            index++;
        }
    }
}
