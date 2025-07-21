package TPJAVA;

public enum Couleur {
    ROUGE,
    VERT,
    BLEU,
    JAUNE,
    NOIR;

    public static Couleur getCouleurDefaut() {
        return Couleur.NOIR;
    }
//
//    public static Couleur getCouleur(String code) {
//        switch (code) {
//            case "R":
//                return Couleur.ROUGE;
//
//            case "V":
//                return Couleur.VERT;
//
//            case "B":
//                return Couleur.BLEU;
//
//            case "J":
//                return Couleur.JAUNE;
//
//            case "N":
//                return Couleur.NOIR;
//
//            default:
//                return getCouleurDefaut();
//        }
//    }
}
