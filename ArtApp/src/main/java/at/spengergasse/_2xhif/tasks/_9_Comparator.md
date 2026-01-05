# Comparator

Möchte man in Java eine Liste sortieren, die nicht aus primitiven Datentypen besteht, sondern aus einer komplexen Klasse,
benötigt man einen _Comparator_, über welchen man das Sortierverhalten steuern kann. Dies werden wir in unserer App
in einer neuen Klasse _DataStore_ implementieren. _DataStore_ ist vorläufig eine Klasse, welche mittels des POIReaders
Daten aus einer Textdatei liest und eine sortierte Liste von POIs retourniert.

Die Liste soll sortiert werden nach:

1. Absteigend nach dem Jahr
2. Aufsteigend nach dem Titel

**Beispiel:**

- <1> Gemälde 1 (2025)
- <2> Altes Gemälde (1050)
- <3> Ziemlich altes Gemälde (1050)

## Aufgabe

- Erstelle eine neue Klasse _DataStore_, welche im Konstruktor den Pfad zu einer Textdatei enthält.
- Erstelle dann eine Methode _load_, welche den Pfad an einen POIReader weitergibt und von diesem die POIs entgegennimmt.
- In der Methode _load_, sortiere die geladenen POIs nach dem oben genannten Schema. Verwende hierfür einen Comparator, den du in _DataStore_ implementierst.
- Teste deine Implementierung mittels eines Unit-Tests. Nimm hierfür ein gültiges File (_correct.txt_) und stelle sicher, dass die Sortierung funktioniert.