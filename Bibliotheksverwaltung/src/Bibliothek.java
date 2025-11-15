import java.util.ArrayList;
import java.util.HashMap;

public class Bibliothek {
    // Key: String (aka Buchtitel), Value: Boolean (aka ausgeliehen oder nicht)
    private final HashMap<String, Boolean> mediumRegistry;
    private final ArrayList<Medium> mediums;

    public Bibliothek() {
        // super();
        mediumRegistry = new HashMap<>();
        mediums = new ArrayList<>();
    }

    public void mediumHinzufuegen(final Medium medium) {
        if (medium == null) {
            throw new IllegalArgumentException("medium must not be null!");
        }

        if (mediumRegistry.containsKey(medium.getTitle())) {
            return; // duplicated - don't do anything
        }

        mediumRegistry.put(medium.getTitle(), false);
        mediums.add(medium);
    }

    public void ausleihen(final String title) throws BereitsAusgeliehenException {
        if (title == null) {
            throw new IllegalArgumentException("title must not be null!");
        }

        // gibt es das Medium überhaupt?
        if (!mediumRegistry.containsKey(title)) {
            throw new IllegalStateException("mediumRegistry doesn't contain medium titled " + title);
        }

        if (mediumRegistry.get(title)) { // if true: ausgeliehen... ist hier aber schlecht
            throw new BereitsAusgeliehenException("Medium wurde bereits ausgeliehen!", title);
        } else { // if false: wir leihen es aus
            mediumRegistry.put(title, true);
        }
    }

    public void zurueckgeben(final String title) {
        if (title == null) {
            throw new IllegalArgumentException("title must not be null!");
        }

        // gibt es das Medium überhaupt?
        if (!mediumRegistry.containsKey(title)) {
            throw new IllegalStateException("mediumRegistry doesn't contain medium titled " + title);
        }

        mediumRegistry.put(title, false);
    }

    public void anzeigen() {
        for (final Medium m : mediums) {
            final String info = m.info();
            final String ausgeliehenStatus;

            if (mediumRegistry.get(m.getTitle())) { // true == ist ausgeliehen
                ausgeliehenStatus = "(ausgeliehen)";
            } else { // false == nicht ausgeliehen
                ausgeliehenStatus = "(nicht ausgeliehen)";
            }

            System.out.println(info + " " + ausgeliehenStatus);
        }
    }
}
