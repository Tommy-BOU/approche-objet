package fr.diginamic.maison;

import java.util.ArrayList;
import java.util.Collection;

public class Maison {
    Collection<Piece> piecesDeLaMaison = new ArrayList<>();

    public void ajouterPiece(Piece piece) throws NullPointerException{
        if (piece == null){
            throw new NullPointerException("Impossible de passer le paramètre null à la méthode ajouterPiece");
        }
        piecesDeLaMaison.add(piece);
    }

    public double getTotalSuperficie() {
        double total = 0;
        for (Piece piece : piecesDeLaMaison) {
            total += piece.getSuperficie();
        }
        return total;
    }

    public double getEtageSuperficie(int etage) {
        double total = 0;
        for (Piece piece : piecesDeLaMaison) {
            if (piece.getNumeroDEtage() == etage) {
                total += piece.getSuperficie();
            }
        }
        return total;
    }

    public String toString(){
        String string = "Pièces de la maison : \n";

        for (Piece piece : piecesDeLaMaison){
            string += piece + " - Superficie : " + piece.getSuperficie() + " - Numero d'etage : " + piece.getNumeroDEtage() + "\n";
        }
        return string;
    }

    public double getSuperficieByRoomType(String pieceType){
        double total = 0;
        for (Piece piece : piecesDeLaMaison) {
            if (piece.toString() == pieceType) {
                total += piece.getSuperficie();

            }
        }
        return total;
    }

    public int getNumberOfRoomByType(String pieceType){
        int total = 0;
        for (Piece piece : piecesDeLaMaison) {
            if (piece.toString() == pieceType) {
                total ++;
            }
        }
        return total;
    }
}
