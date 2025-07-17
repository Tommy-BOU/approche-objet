package TPJAVA;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class FigureUtil {
    private static final Random random = new Random();

    private static Point getRandomPoint() {
        return new Point(random.nextInt(100), random.nextInt(100));
    }

    public Rond getRandomRond() {
        return new Rond(getRandomPoint(), random.nextInt(100));
    }

    public Rectangle getRandomRectangle() {
        return new Rectangle(getRandomPoint(), random.nextInt(100), random.nextInt(100));
    }

    public Carre getRandomCarre() {
        return new Carre(getRandomPoint(), random.nextInt(100));
    }

    public CarreHerite getRandomCarreHerite() {
        return new CarreHerite(getRandomPoint(), random.nextInt(100));
    }

    public Segment getRandomSegment() {
        return new Segment(getRandomPoint(), random.nextInt(100), random.nextBoolean());
    }

    public Figure getRandomFigure() {
        int figureNum = random.nextInt(5);

        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            case 3 -> getRandomSegment();
            default -> getRandomCarre();
        };
    }

    public Surfaçable getRandomSurfaçable() {
        int figureNum = random.nextInt(4);

        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            default -> getRandomCarre();
        };
    }

    public Collection<Point> getPoints(Collection<Figure> figures) {
        Collection<Point> points = new LinkedHashSet<>();

        for (Figure figure : figures) {
            points.addAll(figure.getPoints());
        }

        return points;
    }

    public Collection<Figure> genere(int nbFigures) {
        Collection<Figure> randomFigures = new LinkedHashSet<>(nbFigures);

        for (int i = 0; i < nbFigures; i++) {
            randomFigures.add(getRandomFigure());
        }

        return randomFigures;
    }

    public Figure getFigureEn(Point point, Dessin dessin){
        Iterator<Figure> figures = dessin.getFigures().iterator();

        while(figures.hasNext()) {
            Figure fig = figures.next();
            System.out.println(fig);
            if (fig.couvre(point)){
                return fig;
            }
        }

        return null;
    }
}
