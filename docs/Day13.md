# [Tag 13: Point of Incidence](https://adventofcode.com/2023/day/13)

## Teil 1

### Überlegungen

#### Horizontale Achse

- Die Zeilen werden der Reihe nach durchlaufen
- Für die aktuelle Zeile a wird geprüft, ob und wo sich in den dahinter liegenden Zeilen eine identische findet (z)
- Zwischen diesen beiden Zeilen befindet sich eine potentielle Spiegelachse
- Wenn alle Zeilen zwischen den gefundenen Zeilen paarweise symmetrisch sind (also a+1 == z-1, a+2 == z-2 usw.)
  - Es ist verlockend hier abzukürzen und gleich die Mitte auszurechnen
  - Dann die beiden Zeilen oberhalb und unterhalb dieser Mitte vergleichen
  - das birgt allerdings die Gefahr, dass diese beiden Zeile rein zufällig identisch sind

## Teil 2
