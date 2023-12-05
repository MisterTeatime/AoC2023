# [Tag 4: Scratchcards](https://adventofcode.com/2023/day/4)

Mit der Helfermethode ```getHittingNumbersCount()``` wird die Anzahl der Zahlen einer Karte ermittelt, die ein Treffer sind. Dazu wird die Eingabe in zwei Listen von Integer umgewandelt. Die Zahlen vor dem Trennzeichen sind die Glückszahlen, die Zahlen danach die gezogenen Zahlen. Über die zweite Liste wird iteriert und geprüft, ob die Zahl unter den Glückszahlen ist. In diesem Fall wird der Zähler um 1 erhöht. Am Ende der Iteration wird das Ergebnis zurückgegeben.

## Teil 1

Die Eingabe wird transformiert, so dass am Ende nur noch die Zahlen mit Trennzeichen übrigbleiben. Die Gewinnerzahlen werden ermittelt. Da der Score durch eine 2er Potenz berechnet wird und der erste Treffer 1 Punkt wert ist, wird die Anzahl der Gewinnerzahlen um 1 reduziert.

Sollte die Anzahl der Gewinnerkarten jetzt größer als 0 sein (es gab also mindestens einen Treffer), dann wird der Score berechnet mit 2 ^ Anzahl ermittelt und auf die Gesamtsumme hinzuaddiert. Sind alle Karten abgearbeitet, wird der Gesamtscore ausgegeben.

**Lösung:** 20855

## Teil 2

Die Eingabe wird wie in Teil 1 transformiert. Zusätzlich wird eine Map<Int, Int> generiert, die jedem Index einer Karte die Anzahl zuordnet. Die Map wird als mit dem Wert 1 für jeden Eintrag initialisiert.

Es wird wieder über jede Karte iteriert und die Trefferanzahl ermittelt. Gab es mindestens einen Treffer, dann werden die Folgeindizes in einer Range ermittelt und die entsprechenden Einträge in der Map um die Anzahl der Karten des aktuellen Index erhöht. Wenn es 3 Kopien der Karte mit Index 4 gibt und diese 3 Treffer hat, dann werden die Indizes 5, 6 und 7 um jeweils 3 erhöht. Laut Vorgabe ist dafür gesorgt, dass nie über das Ende der Karten hinaus Kopien angefordert werden.

Um die Gesamtzahl der Karten nach der Interation zu erhalten, werden die values der Map zusammengezählt.

**Lösung:** 5489600


