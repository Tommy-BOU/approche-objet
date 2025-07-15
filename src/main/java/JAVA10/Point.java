package JAVA10;

public class Point {

        int xPos;
        int yPos;

        public Point(int x, int y){
            this.xPos = x;
            this.yPos = y;
        }

        public int getX(){
            return this.xPos;
        }

        public int getY(){
            return this.yPos;
        }

        public String toString(){
            return "[" + xPos + ";" + yPos + "]";
        }

}
