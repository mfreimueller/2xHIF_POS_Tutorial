import java.util.HashMap;

/**
 * Speichert eine Menge an Fahrzeugen in einer HashMap. Bietet Hilfsfunktionen
 * für das Ein- und Ausparken an.
 */
public class Garage {
    /**
     * Eine HashMap, die als Key das Kennzeichen eines Fahrzeugs speichert, und als Wert das Fahrzeug selbst.
     * Ich kann also mithilfe des Kennzeichens mein Fahrzeug finden.
     */
    private HashMap<String, Fahrzeug> geparkteFahrzeuge;

    public Garage() {
        geparkteFahrzeuge = new HashMap<>();
    }

    public void parkeEin(String kennzeichen, Fahrzeug fahrzeug) throws DoppeltesKennzeichenException {
        if (fahrzeug == null) {
            throw new IllegalArgumentException("fahrzeug must not be null!");
        } else if (kennzeichen == null || kennzeichen.isBlank()) {
            throw new IllegalArgumentException("kennzeichen must not be null or an empty String!");
        }

        if (geparkteFahrzeuge.containsKey(kennzeichen)) {
            throw new DoppeltesKennzeichenException(kennzeichen);
        }

        // .put verbindet das Fahrzeug mit dem Kennzeichen
        // ACHTUNG: ich könnte dasselbe Fahrzeug mit verschiedenen Kennzeichen speichern!
        // Also ist nur der Schlüssel (Kennzeichen) eindeutig, das Fahrzeug aber nicht.
        geparkteFahrzeuge.put(kennzeichen, fahrzeug);
    }

    public Fahrzeug parkeAus(String kennzeichen) {
        if (kennzeichen == null || kennzeichen.isBlank()) {
            throw new IllegalArgumentException("kennzeichen must not be null or an empty String!");
        }

        // .remove liefert das Fahrzeug mit dem Kennzeichen zurück - oder null, falls es das nicht gibt
        return geparkteFahrzeuge.remove(kennzeichen);
    }

    public boolean hatFahrzeugMitKennzeichen(String kennzeichen) {
        if (kennzeichen == null || kennzeichen.isBlank()) {
            throw new IllegalArgumentException("kennzeichen must not be null or an empty String!");
        }

        return geparkteFahrzeuge.containsKey(kennzeichen);
    }
}
