package fr.diginamic.essais;

import fr.diginamic.operations.Operations;

public class TestOperations {
    public static void main(String[] args) {
        System.out.println("1 + 2 = " + Operations.calcul(1, '+', 2));
        System.out.println("10 - 5 = " + Operations.calcul(10, '-', 5));
        System.out.println("10 * 10 = " + Operations.calcul(10, '*', 10));
        System.out.println("50 / 10 = " + Operations.calcul(50, '/', 10));
    }
}
