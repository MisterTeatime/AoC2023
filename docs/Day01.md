# [Tag 1: Trebuchet?!](https://adventofcode.com/2023/day/1)

## Übersicht

Die Eingabe ist ein Dokument zur Kalibrierung eines Trebuchets. Jede Zeile enthält Ziffern, die jeweils erste und letzte Ziffer sollen zu einer Zahl zusammengefasst werden und dann sollen alle Zeilen aufsummiert werden.

## Teil 1

Ziffern sind "echte" Ziffern, also die Zeichen 0, 1, 2, 3, 4, 5, 6, 7, 8 und 9.

Die Eingabe wird über verschiedene Aufrufe von ```map{ }``` umgeformt. Zuerst werden alle Nicht-Ziffern entfernt. Als nächstes werden die übriggebliebenen Ziffern auf die erste und die letzte reduziert. Besonderheit ist, dass im Fall, dass es nur eine Ziffer gibt, diese zwei Mal verwendet wird. Als letzter Schritt werden die so entstandenen Zahlen mit ```sumOf { it -> it.toInt() }``` aufsummiert.

**Lösung:** 55607

## Teil 2

Ziffern können auch in Worte ausgeschrieben werden. Also: one, two, three, four, five, six, seven, eight, nine.

Wichtig hierbei ist, dass es vorkommen kann, dass die Worte zusammengezogen werden. Z.B. *oneight* oder *eightwo*. Unter Umständen können auch längere Ketten gebildet werden wie *oneightwone". Aus den Beispielen ist nicht klar erkenntlich, ob hier jedes Ziffernwort genommen werden soll (also z.B. *oneightwone* -> 1821) oder nur die nach einer Ersetzung vollständigen (also z.B. *oneightwone" -> 12). In Tests zeigte sich dann, dass die erste Variante korrekt ist.

### Umsetzung

Analog zu Teil 1 wird die Eingabe in mehreren Schritten transformiert. Konkret wird nur der erste Schritt (entfernen von Nicht-Ziffern) ersetzt bzw. erweitert. Dazu wird eine neue Funktion ```convertToDigits()``` eingeführt. Sie erhält eine Zeile aus der Eingabe als Input.

Der Eingabestring wird zeichenweise durchlaufen. Das aktuelle Zeichen wird geprüft, ob es ich um eine Ziffer handelt. In diesem Fall wird das Zeichen in das Ergebnis übernommen und der Index um 1 erhöht. Im anderen Fall wird geprüft, ob es sich beim Zeichen um den Beginn eines Zifferworts handelt.

Dazu wird eine Map definiert, die dem englischen Zifferwort die korrekte Ziffer zuordnet. Über diese Map wird jetzt iteriert und geprüft. ob ab dem aktuellen Index das aktuelle Zifferwort beginnt. Dies geschieht mit ```input.startsWith(zahl, index)```. Liefert die Prüfung *true* wird die dazugehörige Ziffer in das Ergebnis übernommen. Der Index wird um die Länge des Zifferworts - 1 verschoben. Er zeigt damit auf den letzten Buchstaben des Zifferworts. Damit ist sichergestellt, dass bei einer Verkettung auch das nächste Zifferwort erkannt wird. Würde der Index um die volle Länger verschoben, dann würde dem folgenden Wort der erste Buchstabe fehlen und es somit nicht erkannt werden. Sollte kein Zifferwort passen, dann wird der Index einfach nur um 1 erhöht und das aktuelle Zeichen verworfen.

Die folgenden Schritte der Transformation sind identisch mit Teil 1:

- Die Ziffernkette wird auf die erste und letzte Ziffer reduziert, sollte nur eine Ziffer vorhanden sein, wird diese doppelt gewertet
- Die zweistelligen Zahlen werden in Longs umgewandelt (falls die Gesamtsummer an die Grenzen von Int heranreicht)
- Die Zahlen werden aufsummiert und das Ergebnis ausgegeben.

**Lösung:** 55291
