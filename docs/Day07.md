# [Tag 7: Camel Cards](https://adventofcode.com/2023/day/7)

## Teil 1

### Überlegungen

- Sowohl Kartenwerte als auch die Hände sollten in zwei Maps (oder Lists) erfasst werden, damit ihnen ein Rang zugeordnet werden kann
- Die Zeilen der Eingabe werden als Paare **(Hand, Einsatz)** (oder eigene Klasse) in einer Liste gesammelt
- Es wird eine eigene Sortiermethode entwickelt, die die Hand-Einsatz-Paare nach den Vorgaben und mit Hilfe der Ranglisten so sortiert, dass die wertvollste hinten steht. Damit hat sie dann Rang = Index + 1

## Teil 2