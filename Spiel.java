import java.util.ArrayList;

public class Spiel {

    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktuellerspieler;
    private Spielfeld spielfeld;
    private int anzahlzuege;
    private boolean spielbeendet;
    private ArrayList<Integer> zugliste;

    public void startespiel() {
        spieler1 = new Spieler(1, 'X');
        spieler2 = new Spieler(2, 'O');
        aktuellerspieler = spieler1;
        spielfeld = new Spielfeld();
        spielfeld.initialisieren();
        anzahlzuege = 0;
        spielbeendet = false;
        zugliste = new ArrayList<Integer>();
        spielfeld.anzeigen();
    }

    public void zugausfuehren(int spalte) {
        if (spielbeendet) {
            return;
        }
        if (!spielfeld.einwerfen(spalte, aktuellerspieler.getZeichen())) {
            System.out.println("Spalte " + spalte + " ist voll oder ungültig.");
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
                + " (" + aktuellerspieler.getZeichen() + ") gewinnt.");
    }
}
