package TPJAVA;

import java.lang.reflect.Array;
import java.util.Arrays;
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

        // This should never happen
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

        // This should never happen
        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            default -> getRandomCarre();
        };
    }

    public Point[] getPoints(Figure... figures) {
        int arraySize = 0;

        for (Figure figure : figures) {
            int pointsNum = 0;

            for (Point point : figure.getPoints()) {
                pointsNum++;
            }

            arraySize += pointsNum;
        }

        Point[] points = new Point[arraySize];

        int index = 0;

        for (Figure figure : figures) {

            for (Point point : figure.getPoints()) {

                points[index] = point;
                index++;
            }

        }

        return points;
    }
}
