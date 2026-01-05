# Task 7: Properties

Um das Verhalten unserer App zu steuern, nachdem wir sie kompiliert und ausgerollt (also deployed - veröffentlicht)
haben, benötigen wir Konfigurationsfiles. Typische moderne Varianten davon sind JSON, TOML oder auch immer noch XML.
Ebenfalls möglich, wenngleich zunehmend veraltet, sind einfache Property-Files, welche man von Windows und den ini-Dateien
kennt.

Ein Property-File besteht aus Key-Value-Paaren, was uns nicht unbekannt ist, da wir bereits gelernt haben, mit Maps
zu arbeiten. Die bedeutende Einschränkung von Property-File ist allerdings, dass es nur eine Ebene gibt, also hat 
jeder Key genau einen Value und kann nicht, wie man Maps möglich, dahinter eine komplexere Struktur enthalten. Dafür
bietet sich zB JSON an.

## Aufgabe

1. Schreibe eine Klasse AppConfig, welche aus einer Konfigurationsdatei folgende Werte ausliest:

   - supportedTourType
   - isPublic
   - maxPOIs

    _supportedTourType_ kann entweder den Wert "HistoryTour" oder "RandomTour" übernehmen und dient dazu, einen bestimmten
    Tour Typen für den Benutzer zu aktivieren.
    
    _isPublic_ ist entweder "true" oder "false" und gibt an, ob die App nur "inhouse", also im Museum, verwendet wird,
    oder ob sie öffentlich zugänglich ist. Das beeinflusst unter Umständen, welche Artworks aus Lizenzgründen angezeigt
    werden können.
    
    _maxPOIs_ gibt an, wie viele POIs ein Benutzer maximal betrachten kann. Dies kann man zB verwenden, um eine Gratis-
    und eine Bezahlversion der App zu ermöglichen.

    Die Klasse benötigt Getter, um auf die Werte zuzugreifen.

2. Erstelle eine _config.properties_ Datei mit den drei Schlüsseln und sinnvollen Werten.
3. Erstelle einen Unit-Test, bei dem du folgende Szenarien testest:
   - Gültige Datei wird geladen und liest die richtigen Werte aus.
   - Fehlende Datei wird geladen - sollte FileNotFoundException werfen.
   - Ungültige Datei wird geladen - sollte bei Zugriff mittels Getter eine "IllegalStateException" werfen