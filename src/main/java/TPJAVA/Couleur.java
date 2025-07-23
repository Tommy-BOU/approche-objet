package TPJAVA;

public enum Couleur {
    ROUGE('R'),
    VERT('V'),
    BLEU('B'),
    JAUNE('J'),
    NOIR('N');

    char code;

    Couleur (char code){
        this.code = code;
    }

    public static Couleur getCouleurDefaut() {
        return Couleur.NOIR;
    }
//
    public static Couleur getCouleur(char code) {
        return switch (code) {
            case 'R' -> Couleur.ROUGE;
            case 'V' -> Couleur.VERT;
            case 'B' -> Couleur.BLEU;
            case 'J' -> Couleur.JAUNE;
            case 'N' -> Couleur.NOIR;
            default -> getCouleurDefaut();
        };
    }
}
