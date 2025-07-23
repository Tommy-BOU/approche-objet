package TPJAVA;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        return new Segment(p, getRandomColor(), (h ? random.nextInt(100 - p.getX()) : random.nextInt(100 - p.getY())), h);
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

    public Surfacable getRandomSurfacable() throws DessinHorsLimiteException {
        int figureNum = random.nextInt(4);

        return switch (figureNum) {
            case 0 -> getRandomRond();
            case 1 -> getRandomRectangle();
            case 2 -> getRandomCarreHerite();
            default -> getRandomCarre();
        };
    }

    public static Couleur getRandomColor() {
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

    public Collection<Surfacable> trieDominant(Dessin dessin) {
        ArrayList<Surfacable> list = new ArrayList<>();
        for (Figure figure : dessin.getFigures()) {
            if (Surfacable.class.isAssignableFrom(figure.getClass())) {
                list.add((Surfacable) figure);
            }
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Surfacable o1, Surfacable o2) {
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

    public static void save(Dessin dessin, String name) throws IOException {
        String fileString = "";
        for (Figure figure : dessin.getFigures()) {
            fileString += "{" + "\n" + "TYPE=[" + figure.getType() + "]\n" + "COLOR=[" + figure.getColor() + "]\n" + "INIT_X=[" + figure.initialPoint.getX() + "]\n" + "INIT_Y=[" + figure.initialPoint.getY() + "]\n";
            switch (figure.getType()) {
                case "CARRE" -> fileString += "SIZE=[" + ((Carre) figure).borderSize + "]\n";
                case "CARREHERITE" -> fileString += "SIZE=[" + ((CarreHerite) figure).width + "]\n";
                case "RECT" ->
                        fileString += "WIDTH=[" + ((Rectangle) figure).width + "]\n" + "HEIGHT=[" + ((Rectangle) figure).height + "]\n";
                case "ROND" -> fileString += "RADIUS=[" + ((Rond) figure).radius + "]\n";
                case "SEGMENT" ->
                        fileString += "LENGTH=[" + ((Segment) figure).length + "]\n" + "HORIZONTAL=[" + ((Segment) figure).horizontal + "]\n";
            }

            fileString += "}" + "\n";
        }

        Files.createDirectories(Paths.get("./saves"));
        try {
            File myObj = new File("./saves/" + name + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("./saves/" + name + ".txt"));
            writer.write(fileString);

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Dessin load(String name) throws IOException, DessinHorsLimiteException {
        Dessin loadedDessin = new Dessin();
        BufferedReader br = new BufferedReader(new FileReader("./saves/" + name + ".txt"));

        String type = "";
        Couleur color = Couleur.getCouleurDefaut();
        int initX = 0;
        int initY = 0;
        int valueX = 0;
        int valueY = 0;
        boolean horizontal = false;
        try {
            String line = br.readLine();

            while (line != null) {
                int endIndex = line.indexOf("]");
                int startIndex = line.indexOf("[");
                String value = "";
                if (line.length() > 1) {
                    value = line.substring(startIndex + 1, endIndex);
                }
                if (line.contains("TYPE")) {
                    type = value;
                } else if (line.contains("COLOR")) {
                    color = Couleur.getCouleur(value.charAt(0));
                } else if (line.contains("INIT_X")) {
                    initX = Integer.parseInt(value);
                } else if (line.contains("INIT_Y")) {
                    initY = Integer.parseInt(value);
                } else if (line.contains("SIZE")) {
                    valueX = Integer.parseInt(value);
                } else if (line.contains("RADIUS")) {
                    valueX = Integer.parseInt(value);
                } else if (line.contains("WIDTH")) {
                    valueX = Integer.parseInt(value);
                } else if (line.contains("HEIGHT")) {
                    valueY = Integer.parseInt(value);
                } else if (line.contains("HORIZONTAL")) {
                    horizontal = Boolean.parseBoolean(value);
                } else if (line.contains("LENGTH")) {
                    valueX = Integer.parseInt(value);
                } else if (line.contains("}")) {
                    Figure newFig = null;
                    Point initialPoint = new Point(initX, initY);
                    newFig = switch (type) {
                        case "CARRE" -> new Carre(initialPoint, color, valueX);
                        case "CARREHERITE" -> new CarreHerite(initialPoint, color, valueX);
                        case "RECT" -> new Rectangle(initialPoint, color, valueX, valueY);
                        case "ROND" -> new Rond(initialPoint, color, valueX);
                        case "SEGMENT" -> new Segment(initialPoint, color, valueX, horizontal);
                        default -> newFig;
                    };
                    loadedDessin.add(newFig);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred : " + e.getMessage());
            e.printStackTrace();
        } finally {
            br.close();
        }
        return loadedDessin;
    }
}
