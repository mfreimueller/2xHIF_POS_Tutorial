# Task 8: Polymorphismus

Damit die Benutzer unserer App auch Inhalte zu sehen bekommen, führen wir ein neues Element, "Content", ein. Content
stellt ein beliebiges Multimedia-Element dar, das in irgendeiner Form dem Benutzer ein Kunstwerk veranschaulicht. Aktuell
kennt unsere App folgende Content-Typen:

- Image
- Video
- Audio

Da wir zur Compilezeit nicht wissen, welche Artworks welche Content-Typen haben, und da ein Artwork mehrere Bilder
oder Audios etc. besitzen kann und da die unterschiedlichen Content-Typen zwar im Grunde gleich sind, aber
unterschiedliche Businesslogiken haben (zB spielt man ein Audio ab, während man ein Bild anzeigt), brauchen wir einen
Mechanismus, der diese Vielfältigkeit unterstützt: Polymorphismus.

Es gibt eine Basisklasse "Content", welche die Parentclass aller anderer Content-Typen ist. Das Besondere ist, dass
wir im POI nur eine Liste von Content-Elementen speichern, ohne zu wissen, ob es sich dabei um ein Bild, ein Video
etc. handelt. Das kann uns egal sein, da wir über Polymorphismus jeden Content-Type so behandeln können, als wäre
es ein einfacher Content.

## Aufgabe

1. Erstelle für die drei Content-Typen geeignete Subklassen: AudioContent, ImageContent und VideoContent
2. Implementiere in den Subklassen die Methode "present", welche vorerst nur folgende Ausgaben mit System.out.println enthalten sollen:
    - AudioContent: "Playing audio: <file path>"
    - ImageContent: "Displaying image: <file path>"
    - VideoContent: "Playing Video: <file path>"
3. Füge in POI eine neue Liste von Content-Elementen ein, inklusive passender Getter und Setter.