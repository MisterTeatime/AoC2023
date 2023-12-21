# [Tag 20: Pulse Propagation](https://adventofcode.com/2023/day/20)

## allgemeiner Lösungsansatz

- Die Module werden als Klassen implementiert, die die Logik für Verarbeitung eines Pulse enthalten
  - Konkret gibt die Verarbeitungsfunktion am Ende zurück, was für ein Pulsestatus ausgegeben wird
- Ein Pulse stellt eine Enumeration zur Verfügung, die die möglichen Status bereitstellt (*LOW*, *HIGH*, *NONE*)
  - *NONE* hat eine Sonderfunktion und wird nur genutzt, um zu erkennen zu geben, dass nichts passiert (kein Pulse wird erzeugt)
- Die Rückmeldung eines Modules wird für die Erzeugung von Pulsen verwendet, die in einer Queue abgelegt werden
  - Immer der vorderste Pulse wird als nächstes abgearbeitet
  - Wenn die Queue leer ist, ist der Tastendruck vollständig verarbeitet
- Der Controller übernimmt die Überwachung der Verabeitung. Er... 
  - ...erzeugt und initialisieren die Module basierend auf der Eingabe
  - ...verwaltet die Queue
  - ...ruft die Verarbeitungsfunktion des aktiven Moduls auf
  - ...erzeugt die weiteren Pulse aufgrund der Rückantwort des Moduls
  - ...führt die Statistik wie oft ein *LOW* oder *HIGH* ausgelöst wurde

## Teil 1

- Folgende Module werden benötigt:
  - **FlipFlop**: Verhalten wie in der Spezifikation beschrieben
  - **Conjunction**: Verhalten wie in der Spezifikation beschrieben
  - **Button**: Sendet immer *LOW*
  - **SimpleModule**: Sendet den Status aus dem erhaltenen Pulse

## Teil 2
