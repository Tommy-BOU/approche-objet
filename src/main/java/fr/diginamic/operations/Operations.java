package fr.diginamic.operations;

public class Operations {

    public static double calcul(double a, char operateur, double b){
        return switch (operateur) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }

}
