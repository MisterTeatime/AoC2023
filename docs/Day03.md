# [Tag 03: Gear Ratios](https://adventofcode.com/2023/day/3)

## Teil 1

### Überlegungen

- Ausschlaggebend sind die Zahlen der Teile
- Es ist nicht notwendig, dass die genauen Positionen der Teile für die Lösung erfasst werden
- Die Eingabe wird durchsucht
  - Immer wenn eine Ziffer entdeckt wird, wird ihre Länge ermittelt und dann überprüft, ob die umgebenden Zellen ein Symbol enthalten (keine Ziffer, kein ```.```)
    - Gibt es ein Symbol, dann wir die Zahl der Summe hinzugefügt
    - Gibt es kein Symbol wird die Zahl ignoriert
  - Die Suche wird immer nach der Zahl fortgesetzt
  - Aufteilung
    - Eine Funktion, die nach Ziffern sucht und die zweite Funktion für die Auswertung aufruft
    - Eine Funktion, die bestimmt, ob die gefundene Zahl gewertet werden muss
      - Sie erhält die Eingabe, Zeile und Spalte der ersten Ziffer der Zahl, die bisherige Summe
      - Sie verändert ggf. die Summe
      - Sie gibt die Länge der Zahl zurück (damit weiß der Aufrufer, wo er weitermachen muss)