package entites;

public class TestAdressePostale {
    public static void main(String[] args) {
        AdressePostale adr1 = new AdressePostale();
        AdressePostale adr2 = new AdressePostale();

        adr1.numeroDeRue = 5;
        adr1.libelleDeLaRue = "Rue des Pyrénées";
        adr1.codePostal = 90000;
        adr1.ville = "Tour";

        adr1.numeroDeRue = 85;
        adr1.libelleDeLaRue = "Rue Gambetta";
        adr1.codePostal = 74230;
        adr1.ville = "Saint Patois";
    }
}
