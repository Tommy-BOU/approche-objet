package TPJAVA;

import java.util.*;

public class TestClasses {
    public static void main(String[] args) {
        try {
            Point testPoint = new Point(10, 10);

            Rond testRond = new Rond(testPoint, 10);
            Rectangle testRectangle = new Rectangle(new Point(50, 50), 10, 10);


            testRond.affiche();

            testRectangle.affiche();

            FigureUtil fig = new FigureUtil();
            Rond testRond2 = FigureUtil.getRandomRond();
            Rectangle testRectangle2 = FigureUtil.getRandomRectangle();

            testRond2.affiche();
            testRectangle2.affiche();

            Carre testCarre = new Carre(testPoint, 10);
            CarreHerite testCarreHerite = new CarreHerite(testPoint, 10);

            testCarre.affiche();
            testCarreHerite.affiche();

            Carre testCarre2 = FigureUtil.getRandomCarre();
            CarreHerite testCarreHerite2 = FigureUtil.getRandomCarreHerite();

            testCarre2.affiche();
            testCarreHerite2.affiche();

            Point testPoint3 = new Point(10, 10);
            Carre testCarre3 = new Carre(testPoint, 10);
            CarreHerite testCarreHerite3 = new CarreHerite(testPoint, 10);

            System.out.println("testPoint3.equals(testPoint)) : " + testPoint3.equals(testPoint));
            System.out.println("testCarre3.equals(testCarre)) : " + testCarre3.equals(testCarre));
            System.out.println("testCarreHerite3.equals(testCarreHerite)) : " + testCarreHerite3.equals(testCarreHerite));

            Figure testFigure = FigureUtil.getRandomFigure();

            testFigure.affiche();

            Surfacable testSurfacable = fig.getRandomSurfacable();

            System.out.println(testSurfacable.surface());

            Collection<Figure> testCollection = fig.genere(5);
            for (Point point : fig.getPoints(testCollection)) {
                System.out.println("Point " + " " + point);
            }

//        System.out.println("---------------------------------------------------------------------");
////        Random method
//        Collection<Figure> testFigures = fig.genere(10);
//        Dessin testDessin = new Dessin(testFigures);
//        System.out.println("Point couvert par le dessins :" + fig.getFigureEn(testPoint, testDessin));

            System.out.println("---------------------------------------------------------------------");
//        Manual method
            Collection<Figure> testFigures = new LinkedHashSet<>();
            testFigures.add(new Rond(testPoint, 10));
            testFigures.add(new Carre(new Point(50, 50), 20));
            testFigures.add(new Rectangle(new Point(50, 50), 30, 25));
            testFigures.add(new CarreHerite(new Point(10, 10), 9));
            testFigures.add(new Segment(new Point(10, 50), 5, false));
            Dessin testDessin = new Dessin(testFigures);
            System.out.println("Point couvert par le dessins :" + fig.getFigureEn(testPoint, testDessin));

            System.out.println("---------------------------------------------------------------------");

            Segment testSegment = new Segment(testPoint, 10, true);
            Segment testSegment2 = new Segment(testPoint, 10, true);
            Segment testSegment3 = new Segment(testPoint, 20, false);

            System.out.println("Segment 1 et 2 égaux : " + testSegment.equals(testSegment2));
            System.out.println("Segment 1 et 3 égaux : " + testSegment.equals(testSegment3));

            System.out.println("---------------------------------------------------------------------");

            Collection<Figure> testCollection2 = fig.genere(5);
            Dessin testDessin2 = new Dessin(testCollection2);
            testCollection2 = fig.trieProcheOrigine(testDessin2);
            System.out.println("Liste après tri par distance : " + testCollection2);
            for (Figure figure : testCollection2) {
                System.out.println("Distance : " + figure.distanceOrigine() + figure);
            }
            Collection<Surfacable> testCollection3 = fig.trieDominant(testDessin2);
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Liste après tri par surface : " + testCollection3);
            for (Surfacable figure : testCollection3) {
                System.out.println("Distance : " + figure.surface() + figure);
            }

            Dessin dessinTest2 = new Dessin();

            dessinTest2.add(new Rond(testPoint, Couleur.ROUGE, 50));
            dessinTest2.add(new Rectangle(new Point(25,50), Couleur.BLEU, 25, 36));
            dessinTest2.add(new Segment(new Point(50, 43), Couleur.JAUNE, 20, true));

            FigureUtil.save(dessinTest2, "testFile");

            Dessin dessinTest3 = FigureUtil.load("testFile");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("figures du dessin chargé :");
            for (Figure figure : dessinTest3.getFigures()){
                System.out.println(figure);
            }

            Dessin dessinTestLoad = FigureUtil.load("testNotFound");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
