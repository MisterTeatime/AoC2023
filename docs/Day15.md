# [Tag 15: Lens Library](https://adventofcode.com/2023/day/15)

## Teil 1

Es wird eine Hashfunktion `hashFunction()` geschrieben, die einen String entgegen nimmt und den Hashwert ausgibt.

Die Eingabe umfasst genau eine Zeile. Diese wird genommen und mit `split(",")` in die Einzelteile aufgeteilt. Diese Einzelteile werden dann mit der Hashfunktion in ihren Hashwert umgewandelt und diese aufsummiert.

**Lösung:** 506269

## Teil 2

### BoxHandler Klasse

Für die Verwaltung der Boxen wird eine Klasse *BoxHandler* geschrieben. Sie kapselt die Operationen und die Berechnung *Focusing Power*.

`addLensToBox(box: Int, lens: String, focalLength: Int)` *void*
Zuerst wird geprüft, ob es die Box *box* schon gibt, wenn nicht, wird sie mit einer leeren Liste angelegt.
Als nächstes wird ermittelt, ob es bereits eine Linse mit dem Label *lens* gibt. Sollte es bereits eine solche Linse geben, wird sie durch die neue Linse ersetzt. Dies geschieht mit `set(index, lens to focalLength)`. Gibt es die Linse noch nicht, wird sie mit `add(lens to focalLength)` einfach hinten angefügt.

`removeLensFromBox(box: Int, lens: String)` *void*
Wenn es die Box *box* gibt, wird der Index der Linse mit dem Label *lens* ermittelt. Gibt es die Linse, dann wird sie entfernt.
Sollte nach dem Enfernen die Box leer sein (Liste der Linsen hat Größe 0), dann wird sie komplett entfernt. Dieser Schritt ist zwar nicht wirklich notwendig, aber es hilft, die Liste der Boxen klein zu halten.

`getFocusingPower()` *Int*
Die Boxen werden auf ihre Focusing Power gemappt, in dem die Linsen durch das Produkt aus Index+1 * FocalLength ersetzt und aufsummiert werden.
Das Endergebnis ist dann die Summe der einzelnen Focusing Power der Boxen.

### Ablauf

Zur Vorbereitung wird das erste Element der Eingabe (es sollte nur eines geben) mit `split(",")` in die einzelnen Anweisungen aufgeteilt und jede Anweisung durch `split([=-].toRegex())` in das Label und die FocalLength aufgeteilt. Durch diese Aktion verschwindet zwar der Operator, aber da bei *.-* keine FocalLength angegeben wird, kann der Befehl durch die Existenz der FocalLength abgeleitet werden.

Für jede Anweisung wird dann der Hash-Wert des Labels berechnet, um die Box zu finden, und dann basierend auf der Existenz der FocalLength (s. oben) wird die entsprechende Funktion des BoxHandlers ausgeführt.

Rückgabe ist dann das Ergebnis der Funktion *getFocusingPower()* des BoxHandlers.

**Lösung:** 264021