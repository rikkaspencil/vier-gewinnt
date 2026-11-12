public class Spieler {

    private int spielernr;
    private char zeichen;

    public Spieler(int spielernr, char zeichen) {
        this.spielernr = spielernr;
        this.zeichen = zeichen;
    }

    public int getSpielernr() {
        return spielernr;
    }

    public char getZeichen() {
        return zeichen;
    }
}
