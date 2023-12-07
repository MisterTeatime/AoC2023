# [Tag 6: Wait For It](https://adventofcode.com/2023/day/6)

## Ansatz

Die Eingabe besteht im Kern aus Paaren mit der Dauer des Rennens und dem dazugehörigen Rekord. Der offensichtliche Ansatz ist, dass man einfach durch alle möglichen Drückzeiten iteriert und dann die Zeiten ausfiltert, bei denen der Rekord nicht übertroffen wird. Dieser Ansatz kann besonders bei langen Laufzeiten aber auch viele Ergebnisse erzeugen.

Die konkrete Distanz zu jeder Drückzeit ist unerheblich und muss nicht vorgehalten werden. Interessant ist die erste Zeit und die letzte Zeit, bei der der Rekord übertroffen wird. Die Funktion ```x -> x * (d - x)``` liefert die erreichte Distanz bei einer Renndauer d und einer Drückzeit x. Die Ungleichung ```x * (d - x) > R``` beschreibt die x, die den Rekord R übertreffen. Wenn diese Ungleichung nach x auflöst, erhält man eine quadratische Lösung:

```x = [d ± √(d^2 - 4R)] / 2```

Hierbei beschreibt das Minus die Untergrenze und das Plus die Obergrenze. Die Anzahl der gesuchten Zeiten lässt sich dann mit ```Obergrenze - Untergrenze + 1``` berechnen. Da nur eine ganzzahlige Zeit gedrückt werden kann, wird der ermittelte Wert gerundet. Die Untergrenze nach oben, die Obergrenze nach unten.

Es kann vorkommen, dass eine der Grenzen mit dem Rekord nur gleichzieht. Deswegen muss diese Situation noch geprüft werden und die Grenze korrigiert werden. Die Untergrenze wird um 1 erhöht, analog wird die Obergrenze um 1 gesenkt. Damit ist sichergestellt, dass die so erzeugten Zeiten der Rekord übertreffen.

Die Idee ist jetzt, dass die Eingabe in Paare (Dauer, Rekord) umgewandelt wird und dann mit diesen Werten die Grenzen und die Anzahl der siegreichen Zeiten ermittelt wird.

## Teil 1

Die Eingabe wird am Doppelpunkt gesplittet und nur der zweite Teil behalten. Dieser wird dann mehreren Transformationen unterzogen. Der String wird am Leerzeichen gesplittet, leere Elemente entfernt und die Zahlen in Ints umgewandelt. Mit ```let``` wird jedem Element der ersten Liste (Distanzen) das Element mit dem gleichen Index der Rekorde zugeordnet.

Aus den so erhaltenen Paare werden dann mit der quadratischen die Grenzen errechnet und korrigiert und das Paar auf die Anzahl der siegreichen Zeiten gemappt.

Für das Ergebnis wird dann aus dieser Liste von Integers mit ```fold``` das Produkt gebildet und ausgegeben.

**Lösung:** 2374848

## Teil 2

Abweichend von Teil 1 werden durch die Eingabe nicht mehrere Rennen, sondern nur ein Rennen beschrieben. Die Zahlen einer Zeile müssen zu einer Zahl zusammengefasst werden.

Grundsätzlich wird der gleiche Ansatz wie in Teil 1 verfolgt. Mit ```replace(" ", "")``` werden die Leerzeichen entfernt, was dazuführt, dass alle Ziffern zu einer Zahl werden. Diese wird dann in ein Long umgewandelt. Long wird anstatt Int verwendet, da nicht sicher ist, ob die Grenzen von Int nicht überschritten werden.

An diesem Punkt kann die Transformationskette aus Teil 1 nicht weiterverfolgt werden. Da die Liste nur noch aus 2 Longs besteht, können keine Listenelemente zu Paaren zusammengefasst werden. Stattdessen wird die Grenzenberechnung direkt auf die bis hier erzeugte Liste angewandt. Am Ende wird direkt die Anzahl ausgegeben.

**Lösung:** 39132886