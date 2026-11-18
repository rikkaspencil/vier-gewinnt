# Vier gewinnt

Ein einfaches Vier-gewinnt-Spiel für die Konsole, geschrieben in Java.

## Starten

```bash
javac *.java
java App
```

Dann abwechselnd eine Spalte von 1 bis 7 eingeben. Wer zuerst vier Steine
waagerecht, senkrecht oder diagonal hat, gewinnt. Ist das Feld voll, gibt es
ein Unentschieden.

## Dateien

- `App.java` startet das Spiel.
- `Spiel.java` regelt die Runden und die Eingabe.
- `Spielfeld.java` ist das 6x7-Feld und prüft den Gewinn.
- `Spieler.java` ist ein Spieler mit Nummer und Zeichen.
