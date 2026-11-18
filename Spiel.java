import java.util.ArrayList;
import java.util.Scanner;

public class Spiel {

    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktuellerspieler;
    private Spielfeld spielfeld;
    private int anzahlzuege;
    private boolean spielbeendet;
    private ArrayList<Integer> zugliste;

    public void startespiel() {
        spieler1 = new Spieler(1);
        spieler2 = new Spieler(2);
        aktuellerspieler = spieler1;
        spielfeld = new Spielfeld();
        anzahlzuege = 0;
        spielbeendet = false;
        zugliste = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (!spielbeendet) {
            spielfeld.anzeigen();
            System.out.println("Spieler " + aktuellerspieler.getSpielernr()
                    + " (" + aktuellerspieler.getZeichen() + ") ist dran.");
            int spalte = spalteLesen(scanner);
            zugausfuehren(spalte);
        }

        scanner.close();
    }

    public void zugausfuehren(int spalte) {
        if (!spielfeld.einwerfen(spalte, aktuellerspieler.getZeichen())) {
            System.out.println("Das geht nicht. Nochmal.");
            return;
        }

        zugliste.add(spalte);
        anzahlzuege++;

        if (spielfeld.gewinncheck()) {
            spielbeendet = true;
            spielfeld.anzeigen();
            gibGewinner();
            return;
        }

        if (spielfeld.istvoll()) {
            spielbeendet = true;
            spielfeld.anzeigen();
            System.out.println("Unentschieden.");
            return;
        }

        spielerwechseln();
    }

    public void spielerwechseln() {
        if (aktuellerspieler == spieler1) {
            aktuellerspieler = spieler2;
        } else {
            aktuellerspieler = spieler1;
        }
    }

    public void gibGewinner() {
        System.out.println("Spieler " + aktuellerspieler.getSpielernr()
                + " (" + aktuellerspieler.getZeichen() + ") gewinnt!");
    }

    private int spalteLesen(Scanner scanner) {
        System.out.print("Spalte 1-7: ");
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Bitte eine Zahl von 1 bis 7: ");
        }
        return scanner.nextInt();
    }
}
