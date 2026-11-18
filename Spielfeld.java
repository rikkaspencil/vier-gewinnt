public class Spielfeld {

    private static final int ZEILEN = 6;
    private static final int SPALTEN = 7;

    private char[][] feld = new char[ZEILEN][SPALTEN];

    public Spielfeld() {
        initialisieren();
    }

    public void initialisieren() {
        for (int zeile = 0; zeile < ZEILEN; zeile++) {
            for (int spalte = 0; spalte < SPALTEN; spalte++) {
                feld[zeile][spalte] = ' ';
            }
        }
    }

    public void anzeigen() {
        for (int zeile = 0; zeile < ZEILEN; zeile++) {
            for (int spalte = 0; spalte < SPALTEN; spalte++) {
                System.out.print("| " + feld[zeile][spalte] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public boolean einwerfen(int spalte, char zeichen) {
        if (spalte < 1) return false;
        if (spalte > SPALTEN) return false;

        int index = spalte - 1;

        for (int zeile = ZEILEN - 1; zeile >= 0; zeile--) {
            if (feld[zeile][index] == ' ') {
                feld[zeile][index] = zeichen;
                return true;
            }
        }
        return false;
    }

    public boolean gewinncheck() {
        for (int zeile = 0; zeile < ZEILEN; zeile++) {
            for (int spalte = 0; spalte < SPALTEN; spalte++) {
                if (vierInReihe(zeile, spalte, 0, 1)) return true;
                if (vierInReihe(zeile, spalte, 1, 0)) return true;
                if (vierInReihe(zeile, spalte, 1, 1)) return true;
                if (vierInReihe(zeile, spalte, 1, -1)) return true;
            }
        }
        return false;
    }

    // Vier Felder ab (zeile, spalte) in eine Richtung.
    private boolean vierInReihe(int zeile, int spalte, int zeilenSchritt, int spaltenSchritt) {
        char zeichen = feld[zeile][spalte];
        if (zeichen == ' ') return false;

        for (int i = 0; i < 4; i++) {
            int z = zeile + i * zeilenSchritt;
            int s = spalte + i * spaltenSchritt;
            if (z < 0) return false;
            if (z >= ZEILEN) return false;
            if (s < 0) return false;
            if (s >= SPALTEN) return false;
            if (feld[z][s] != zeichen) return false;
        }
        return true;
    }

    public boolean istvoll() {
        for (int spalte = 0; spalte < SPALTEN; spalte++) {
            if (feld[0][spalte] == ' ') return false;
        }
        return true;
    }
}
