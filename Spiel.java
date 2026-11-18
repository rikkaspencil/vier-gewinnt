import java.util.Scanner;

public class Spiel {

    private Spieler spieler1;
    private Spieler spieler2;
    private Spieler aktuellerspieler;
    private Spielfeld spielfeld;
    private boolean spielbeendet;

    public void startespiel() {
        spieler1 = new Spieler(1, 'X');
        spieler2 = new Spieler(2, 'O');
        aktuellerspieler = spieler1;
        spielfeld = new Spielfeld();
        spielbeendet = false;

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
        boolean geklappt = spielfeld.einwerfen(spalte, aktuellerspieler.getZeichen());
        if (!geklappt) {
            System.out.println("Das geht nicht. Nochmal.");
            return;
        }

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
