package at.spengergasse._2xhif.domain;

import at.spengergasse._2xhif.foundation.exception.DuplicatedPOIException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An exhibition is a collection of POIs that visitors can view. Typical examples are "Dauerausstellungen", i.e.
 * exhibitions that are always available (for example: the "Antikensammlung" at KHM).
 */
public class Exhibition {

    // TODO: we need a list that stores the POIs of this exhibition
    private final List<POI> elements;

    public Exhibition() {
        // TODO: initialize the list here
        this.elements = new ArrayList<>();
    }

    /**
     * Adds a new POI to the exhibition. If the POI is already part of this exhibition,
     * a DuplicatedPOIException must be thrown.
     *
     * @param poi The POI that should be added to the exhibition. Must not be null!
     */
    public void addPOI(POI poi) {
        if (poi == null) {
            throw new IllegalArgumentException("poi must not be null!");
        }

        /*for (final POI p : elements) {
            if (p == poi) {
                throw new DuplicatedPOIException(poi.getId());
            }
        }*/

        if (elements.contains(poi)) {
            throw new DuplicatedPOIException(poi.getId());
        }

        elements.add(poi);
    }

    /**
     * Removes a POI from the exhibition, identified by its unique ID. If no such POI
     * was part of this exhibition, false is returned.
     * @param id The unique ID of the POI to remove.
     * @return False if no such POI was found.
     */
    public boolean removePOI(Long id) {
        // for loop
        /*for (int idx = 0; idx < elements.size(); idx++) {
            // long ~= Long
            // Long kann null sein; long kann NICHT null sein
            // Integer; Byte; Short; Boolean; Character -> nullable
            // int; byte; short; boolean; char -> not nullable
            if (elements.get(idx).getId().equals(id)) { // .get(idx) == [idx]
                // I found the index containing the POI to remove...
                elements.remove(idx);
                return true;
            }
        }*/

        // iterator
        /*Iterator<POI> it = elements.iterator();
        while (it.hasNext()) {
            final POI poi = it.next();
            if (poi.getId().equals(id)) {
                it.remove();
                return true;
            }
        }*/

        // foreach loop
        /*for (POI poi : elements) {
            if (poi.getId().equals(id)) {
                elements.remove(poi);
                return true;
            }
        }

        return false;*/

        // most modern (& elegant) version
        return elements.removeIf(poi -> poi.getId().equals(id));
    }

    /**
     * Searches for a POI identified by its unique ID and returns it.
     * @param id The unique ID of the POI to find.
     * @return The POI identified by the ID or null if not found.
     */
    public POI findPOI(Long id) {
        for (final POI poi : elements) {
            if (poi.getId().equals(id)) {
                return poi;
            }
        }

        return null;
    }

    /**
     * @return The number of POIs in this exhibition.
     */
    public int getCount() {
        return elements.size();
    }

    /**
     * Returns a list of all POIs of this exhibition that intersect with the POIs of another exhibition.
     * Think of an inner join in SQL. We want the intersecting elements.
     * @param exhibition Another exhibition that we want to intersect.
     * @return A list of all POIs that are also part of the other exhibition.
     */
    // FIXME: replace Object with the correct response type!
    public ArrayList<POI> intersect(Exhibition exhibition) {
        ArrayList<POI> intersectingElements = new ArrayList<>();

        for (final POI poi : elements) {
            // we need to figure out whether the poi is part of exhibition too, or not
            // if poi is a part of the other exhibition, add it to intersecting elements

            // not so beautiful:
            /*for (final POI p : exhibition.elements) {
                if (poi == p) {
                    intersectingElements.add(poi);
                }
            }*/

            if (exhibition.findPOI(poi.getId()) != null) {
                intersectingElements.add(poi);
            }
        }

        return intersectingElements;
    }

    /**
     * Returns the difference between this exhibition and
     * another one, that is, all POIs that are part of this
     * exhibition but not of the other.
     * @param exhibition Another exhibition to calculate the difference from.
     * @return A list of all POIs that are part of this exhibition but not of the other.
     */
    public ArrayList<POI> difference(Exhibition exhibition) { // FIXME: replace Object with correct response type!
        ArrayList<POI> difference = new ArrayList<>();

        for (final POI poi : elements) {
            if (exhibition.findPOI(poi.getId()) == null) {
                difference.add(poi);
            }
        }

        return difference;
    }

    /**
     * Prints this exhibition to stdout. Should list all POIs.
     */
    public void print() {
        final StringBuilder sb = new StringBuilder();

        for (final POI poi : elements) {
            sb.append("- ").append(poi.toString()).append(",\n");

            // this keeps the comma at the end of the list...
            // System.out.println(sb);
            // sb.setLength(0);
        }

        // ugly:
        // sb.deleteCharAt(sb.length() - 1); // delete \n
        // sb.deleteCharAt(sb.length() - 1); // delete ,

        // also ugly:
        // for (int idx = 0; idx < 2; idx++) sb.deleteCharAt(sb.length() - 1);

        sb.delete(sb.length() - 2, sb.length()); // vorletztes + letztes Zeichen löschen (sb.length(), weil ich bis zu diesem Index gehe, den aber nicht lösche)

        System.out.println(sb);
    }
}
