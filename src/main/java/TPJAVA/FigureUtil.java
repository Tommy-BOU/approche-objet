package TPJAVA;

import java.util.*;

public class FigureUtil {
    private static final Random random = new Random();
    private static final HashMap<String, Figure> figuresHash = new HashMap<>();

    private static Point getRandomPoint() throws DessinHorsLimiteException {
        return new Point(random.nextInt(98) + 1, random.nextInt(98) + 1);
    }

    public static Rond getRandomRond() throws DessinHorsLimiteException {
        Point p = getRandomPoint();
        return new Rond(getRandomPoint(), getRandomColor(), random.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static Rectangle getRandomRectangle() throws DessinHorsLimiteException {
        Point p = getRandomPoint();
        return new Rectangle(p, getRandomColor(), random.nextInt(100 - p.getX()), random.nextInt(100 - p.getY()));
    }

    public static Carre getRandomCarre() throws DessinHorsLimiteException {
        Point p = getRandomPoint();
        return new Carre(p, getRandomColor(), random.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static CarreHerite getRandomCarreHerite() throws DessinHorsLimiteException {
        Point p = getRandomPoint();
        return new CarreHerite(p, getRandomColor(), random.nextInt(100 - Math.max(p.getX(), p.getY())));
    }

    public static Segment getRandomSegment() throws DessinHorsLimiteException {
        Point p = getRandomPoint();
        boolean h = random.nextBoolean();
        return new Segment(p, getRandomColor(), (h ?  random.nextInt(100 - p.getX()) : random.nextInt(100 - p.getY())), h);
    }

    public static Figure getRandomFigure() throws DessinHorsLimiteException {
        int figureNum = random.nextInt(5);

        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            case 3 -> getRandomSegment();
            default -> getRandomCarre();
        };
    }

    public static Figure createRandomFigure(String key) throws DessinHorsLimiteException {
        Figure figure = getRandomFigure();
        figuresHash.put(key, figure);

        return figure;
    }

    public Figure get(String id) {
        return figuresHash.get(id);
    }

    public Surfaçable getRandomSurfaçable() throws DessinHorsLimiteException {
        int figureNum = random.nextInt(4);

        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            default -> getRandomCarre();
        };
    }

    public static Couleur getRandomColor(){
        return Couleur.values()[random.nextInt(Couleur.values().length)];
    }

    public Collection<Point> getPoints(Collection<Figure> figures) {
        Collection<Point> points = new LinkedHashSet<>();

        for (Figure figure : figures) {
            points.addAll(figure.getPoints());
        }

        return points;
    }

    public Collection<Figure> genere(int nbFigures) throws DessinHorsLimiteException {
        Collection<Figure> randomFigures = new LinkedHashSet<>(nbFigures);

        for (int i = 0; i < nbFigures; i++) {
            randomFigures.add(getRandomFigure());
        }

        return randomFigures;
    }

    public Figure getFigureEn(Point point, Dessin dessin) {
        Iterator<Figure> figures = dessin.getFigures().iterator();

        while (figures.hasNext()) {
            Figure fig = figures.next();
            System.out.println(fig);
            if (fig.couvre(point)) {
                return fig;
            }
        }

        return null;
    }

    public Collection<Figure> trieProcheOrigine(Dessin dessin) {
//        List<Figure> figuresList = new ArrayList<>(dessin.getFigures());
//        Collections.sort(figuresList);
//        return figuresList;

        return new TreeSet<>(dessin.getFigures());
    }

    public Collection<Surfaçable> trieDominant(Dessin dessin) {
        ArrayList<Surfaçable> list = new ArrayList<>();
        for (Figure figure : dessin.getFigures()) {
            if (Surfaçable.class.isAssignableFrom(figure.getClass())) {
                list.add((Surfaçable) figure);
            }
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Surfaçable o1, Surfaçable o2) {
                if (o1.surface() > o2.surface()) {
                    return -1;
                } else if (o1.surface() < o2.surface()) {
                    return 1;
                }
                return 0;
            }
        });
        return list;
    }
}
