public class Spieler {

    private int spielernr;

    public Spieler(int spielernr) {
        this.spielernr = spielernr;
    }

    public int getSpielernr() {
        return spielernr;
    }

    public char getZeichen() {
        return spielernr == 1 ? 'X' : 'O';
    }
}
