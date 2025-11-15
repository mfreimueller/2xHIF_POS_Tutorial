package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;

/**
 * A cache for POIs that the user visited, in order to
 * quickly find them when searching by their ID.
 */
public class POICache {
    // TODO: we need a HashMap with appropriate Key-Value's

    public POICache() {

    }

    /**
     * Adds a new POI to the cache. If a POI with the same ID already
     * exists, throw a DuplicatedPOIException.
     * @param poi The POI to add. Must not be null.
     */
    public void addPOI(POI poi) {

    }

    /**
     * Attempts to find a POI by the given ID. If no POI was found, return null.
     * @param id The unique ID of a POI.
     * @return The POI associated with the ID, otherwise false.
     */
    public POI findById(Long id) {
        return null;
    }

    /**
     * Attempts to remove a POI by the given ID. If no POI was found, return false.
     * @param id The unique ID of a POI.
     * @return True if a POI was removed, otherwise false.
     */
    public boolean removeById(Long id) {
        return false;
    }

    /**
     * Should clear the cache and remove any stored POIs.
     */
    public void clear() {

    }
}
