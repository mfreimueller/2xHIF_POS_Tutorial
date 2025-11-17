public class Main {

    static void main() {
        final Buch buch = new Buch("Der Herr der Ringe", "J.R.R. Tolkien", 1954, 1200);
        final Zeitschrift zeitschrift = new Zeitschrift("National Geographic", 2024, 321);

        final Bibliothek bibliothek = new Bibliothek();
        bibliothek.mediumHinzufuegen(buch);
        bibliothek.mediumHinzufuegen(zeitschrift);

        bibliothek.anzeigen();

        System.out.println("Leihe 'Der Herr der Ringe' aus ...");
        try {
            bibliothek.ausleihen(buch.getTitle());
            System.out.println("Medium erfolgreich ausgeliehen!");
        } catch (BereitsAusgeliehenException e) {
            System.out.println(e.getMessage() + " für " + e.getTitle());
            System.err.println("Medium konnte nicht ausgeliehen werden!");
        }

        System.out.println("Leihe 'Der Herr der Ringe' aus ...");
        try {
            bibliothek.ausleihen(buch.getTitle());
            System.err.println("Medium konnte erneut ausgeliehen werden!");
        } catch (BereitsAusgeliehenException e) {
            System.out.println(e.getMessage() + " für " + e.getTitle());

            System.out.println("Fehler: Medium 'Der Herr der Ringe' ist bereits ausgeliehen!");
        }

        bibliothek.anzeigen();

        bibliothek.zurueckgeben(buch.getTitle());

        bibliothek.anzeigen();
    }

}
