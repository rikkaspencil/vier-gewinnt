public class Spielfeld {

    private char[][] feld = new char[6][7];

    public void initialisieren() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                feld[zeile][spalte] = ' ';
            }
        }
    }

    public void anzeigen() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                System.out.print("|" + feld[zeile][spalte]);
            }
            System.out.println("|");
        }
        System.out.println(" 1 2 3 4 5 6 7");
    }

    public boolean einwerfen(int spalte, char zeichen) {
        if (spalte < 1 || spalte > 7) {
            return false;
        }
        int index = spalte - 1;
        for (int zeile = 5; zeile >= 0; zeile--) {
            if (feld[zeile][index] == ' ') {
                feld[zeile][index] = zeichen;
                return true;
            }
        }
        return false;
    }

    public boolean gewinncheck() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                char zeichen = feld[zeile][spalte];
                if (zeichen == ' ') {
                    continue;
                }
                if (spalte + 3 < 7
                        && feld[zeile][spalte + 1] == zeichen
                        && feld[zeile][spalte + 2] == zeichen
                        && feld[zeile][spalte + 3] == zeichen) {
                    return true;
                }
                if (zeile + 3 < 6
                        && feld[zeile + 1][spalte] == zeichen
                        && feld[zeile + 2][spalte] == zeichen
                        && feld[zeile + 3][spalte] == zeichen) {
                    return true;
                }
                if (zeile + 3 < 6 && spalte + 3 < 7
                        && feld[zeile + 1][spalte + 1] == zeichen
                        && feld[zeile + 2][spalte + 2] == zeichen
                        && feld[zeile + 3][spalte + 3] == zeichen) {
                    return true;
                }
                if (zeile + 3 < 6 && spalte - 3 >= 0
                        && feld[zeile + 1][spalte - 1] == zeichen
                        && feld[zeile + 2][spalte - 2] == zeichen
                        && feld[zeile + 3][spalte - 3] == zeichen) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean istvoll() {
        for (int zeile = 0; zeile < 6; zeile++) {
            for (int spalte = 0; spalte < 7; spalte++) {
                if (feld[zeile][spalte] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
