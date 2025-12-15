package at.spengergasse._2xhif.domain;

/**
 * An exhibition is a collection of POIs that visitors can view. Typical examples are "Dauerausstellungen", i.e.
 * exhibitions that are always available (for example: the "Antikensammlung" at KHM).
 */
public class Exhibition {

    // TODO: we need a list that stores the POIs of this exhibition

    public Exhibition() {
        // TODO: initialize the list here
    }

    /**
     * Adds a new POI to the exhibition. If the POI is already part of this exhibition,
     * a DuplicatedPOIException must be thrown.
     *
     * @param poi The POI that should be added to the exhibition. Must not be null!
     */
    public void addPOI(POI poi) {
    }

    /**
     * Removes a POI from the exhibition, identified by its unique ID. If no such POI
     * was part of this exhibition, false is returned.
     *
     * @param id The unique ID of the POI to remove.
     * @return False if no such POI was found.
     */
    public boolean removePOI(Long id) {
        return false;
    }

    /**
     * Searches for a POI identified by its unique ID and returns it.
     *
     * @param id The unique ID of the POI to find.
     * @return The POI identified by the ID or null if not found.
     */
    public POI findPOI(Long id) {
        return null;
    }

    /**
     * @return The number of POIs in this exhibition.
     */
    public int getCount() {
        return 0;
    }

    /**
     * Returns a list of all POIs of this exhibition that intersect with the POIs of another exhibition.
     * Think of an inner join in SQL. We want the intersecting elements.
     *
     * @param exhibition Another exhibition that we want to intersect.
     * @return A list of all POIs that are also part of the other exhibition.
     */
    public Object intersect(Exhibition exhibition) {
        // FIXME: replace Object with the correct response type!
        return null;
    }

    /**
     * Returns the difference between this exhibition and
     * another one, that is, all POIs that are part of this
     * exhibition but not of the other.
     *
     * @param exhibition Another exhibition to calculate the difference from.
     * @return A list of all POIs that are part of this exhibition but not of the other.
     */
    public Object difference(Exhibition exhibition) { // FIXME: replace Object with correct response type!
        return null;
    }

    /**
     * Prints this exhibition to stdout. Should list all POIs.
     */
    public void print() {

    }
}
