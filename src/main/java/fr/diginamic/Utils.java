package fr.diginamic;

public class Utils {

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int inputToInt(String input) {
        if (Utils.isInteger(input)) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Entrée incorrect. Seul les chiffres sont autorisées");
            return 0;
        }
    }

    public static void pressEnterToContinue() {
        System.out.println("-------------------------");
        System.out.println("Appuyez sur entrée pour continuer");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
