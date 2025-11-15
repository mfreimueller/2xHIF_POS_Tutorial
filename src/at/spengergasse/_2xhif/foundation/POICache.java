package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.DuplicatedPOIException;

import java.util.HashMap;

/**
 * A cache for POIs that the user visited, in order to
 * quickly find them when searching by their ID.
 */
public class POICache {
    // TODO: we need a HashMap with appropriate Key-Value's
    private final HashMap<Long, POI> cache;

    public POICache() {
        cache = new HashMap<>();
    }

    /**
     * Adds a new POI to the cache. If a POI with the same ID already
     * exists, throw a DuplicatedPOIException.
     * @param poi The POI to add. Must not be null.
     */
    public void addPOI(POI poi) {
        if (poi == null) {
            throw new IllegalArgumentException("poi must not be null!");
        }

        if (cache.containsKey(poi.getId())) {
            throw new DuplicatedPOIException(poi.getId());
        }

        cache.put(poi.getId(), poi);
    }

    /**
     * Attempts to find a POI by the given ID. If no POI was found, return null.
     * @param id The unique ID of a POI.
     * @return The POI associated with the ID, otherwise false.
     */
    public POI findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null!");
        }

//        if (!cache.containsKey(id)) {
//            return null;
//        }

        return cache.get(id);
    }

    /**
     * Attempts to remove a POI by the given ID. If no POI was found, return false.
     * @param id The unique ID of a POI.
     * @return True if a POI was removed, otherwise false.
     */
    public boolean removeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id must not be null!");
        }

//        if (!cache.containsKey(id)) {
//            return false;
//        }
//
//        cache.remove(id);
//        return true;

        // .remove returns the value associated with the key, or null if not found
        return (cache.remove(id) != null);
    }

    /**
     * Should clear the cache and remove any stored POIs.
     */
    public void clear() {
        // var == vom Compiler implizit erkannt: java.util.Set<Long>
//        var keys = cache.keySet();
//        for (var key : keys) {
//            cache.remove(key);
//        }

        cache.clear();
    }
}
