# POI Reader

Schreibe eine Klasse **POIReader**, welche POIs (Points of Interest - i.e. Artworks) aus einer Textdatei liest und eine
Liste mit POIs erstellt und zurückgibt.

Die Klasse **POIReader** soll mittels einer *Factory Method* erstellt werden, welche den Namen **createReader** trägt
und als einziges Argument den Pfad zur Textdatei enthält. Retourniert wird dann ein vorkonfigurierter **POIReader**,
welcher mit der Methode **readAllPOIs** eine **List<POI>** retourniert.

Fehler, die beim Öffnen der Textdatei auftreten (*IOException*) sollen direkt an den Aufrufer (caller) der Factory Methode
weitergegeben werden (.. throws ..). Wenn in **readAllPOIs** ein Fehler auftritt, etwa weil die Datei *malformed* ist,
also nicht unseren Vorstellungen entspricht, soll eine neue **MalformedFileException** geworfen werden, welche von
**Exception** erbt.

Stelle mittels *Unit-Tests* sicher, dass eine gültige Datei gelesen werden kann (nutze hierfür *correct.txt*). Stelle
außerdem sicher, dass eine Fehlermeldung geworfen wird, wenn kein gültiger Dateiname übergeben wird, oder wenn der
Dateiname zwar gültig, die Datei aber ungültig ist (nutze hierfür *malformed.txt*).