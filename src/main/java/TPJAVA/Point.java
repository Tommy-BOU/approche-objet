package TPJAVA;

public class Point {

        private final static int INIT_X = 25;
        private final static int INIT_Y = 25;

        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point()
        {
            this(INIT_X, INIT_Y);
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public String toString(){
            return "[" + x + ";" + y + "]";
        }

}
