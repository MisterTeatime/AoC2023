# [Tag 09: Mirage Maintenance](https://adventofcode.com/2023/day/9)

## Teil 1

### Überlegung

- Das nächste Element der Sequenz ist das letzte Element der Sequenz plus das letzte Element der Differenzensequenz
- Dieses Element wird genauso gebildet
- Die Ermittlung das Elements kann also rekursiv erfolgen
  - Die Methode erhält eine Eingabesequenz
  - Es wird geprüft, ob die Ende-Bedingung erfüllt ist (alle Element sind 0)
    - in diesem Fall wird eine 0 als letztes Element zurückgegeben
  - Ist die Endebedingung nicht erfüllt, dann wird das nächste Element der Eingabesequenz gesucht
    - Dazu wird die Eingabe mit ```windowed(2, 1)``` in 2er Gruppen mit Schrittweite 1 erzeugt (aus ```[1, 2, 3, 4]``` wird ```[[1,2],[2,3],[3,4]]```), die dann auf ihre Differenz reduziert werden
    - Die so erzeugte Sequenz ist dann die Eingabe für den rekursiven Aufruf
    - Dessen Ergebnis wird zum letzten Element der Squenz addiert und zurückgegeben

## Teil 2