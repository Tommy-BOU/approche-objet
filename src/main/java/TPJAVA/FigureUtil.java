package TPJAVA;

import java.util.Random;

public class FigureUtil {
    private static final Random random = new Random();

    private static Point getRandomPoint(){
        return new Point(random.nextInt(100), random.nextInt(100));
    }

    public Rond getRandomRond(){
        return new Rond(getRandomPoint(), random.nextInt(100));
    }

    public Rectangle getRandomRectangle(){
        return new Rectangle(getRandomPoint(), random.nextInt(100), random.nextInt(100));
    }
}
