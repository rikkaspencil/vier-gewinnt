public class Spielfeld {

    private int[][] feld = new int[6][7];

    public void initialisieren() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                feld[zeile][spalte] = 0;
            }
        }
    }

    public void anzeigen() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                System.out.print(feld[zeile][spalte] + " ");
            }
            System.out.println();
        }
    }

    public boolean einwerfen(int spalte, int spieler) {
        if (spalte < 0 || spalte > 6) {
            return false;
        }
        for (int zeile = 5; zeile >= 0; zeile--) {
            if (feld[zeile][spalte] == 0) {
                feld[zeile][spalte] = spieler;
                return true;
            }
        }
        return false;
    }

    public boolean gewinncheck() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                int spieler = feld[zeile][spalte];
                if (spieler == 0) {
                    continue;
                }
                if (spalte + 3 < 7
                        && feld[zeile][spalte + 1] == spieler
                        && feld[zeile][spalte + 2] == spieler
                        && feld[zeile][spalte + 3] == spieler) {
                    return true;
                }
                if (zeile + 3 < 6
                        && feld[zeile + 1][spalte] == spieler
                        && feld[zeile + 2][spalte] == spieler
                        && feld[zeile + 3][spalte] == spieler) {
                    return true;
                }
                if (zeile + 3 < 6 && spalte + 3 < 7
                        && feld[zeile + 1][spalte + 1] == spieler
                        && feld[zeile + 2][spalte + 2] == spieler
                        && feld[zeile + 3][spalte + 3] == spieler) {
                    return true;
                }
                if (zeile + 3 < 6 && spalte - 3 >= 0
                        && feld[zeile + 1][spalte - 1] == spieler
                        && feld[zeile + 2][spalte - 2] == spieler
                        && feld[zeile + 3][spalte - 3] == spieler) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean istvoll() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                if (feld[zeile][spalte] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
