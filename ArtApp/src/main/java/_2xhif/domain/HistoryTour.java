package _2xhif.domain;

/**
 * Tour uses a linked lists to store a list of POIs that visitors are to visit.
 * This class only supports moving from POI to POI in the given order.
 * POIs are sorted by their year, where the oldest POI is visited first and the youngest last.
 */
public class HistoryTour implements Tour {

    // TODO: implement linked list here!

    /**
     * Adds a new POI to the tour. If the POI is already part of the Tour, a DuplicatedEntryException
     * is to be thrown. The POI is inserted into the tour correctly by sorting it using getYear().
     *
     * @param poi A POI to add to the tour.
     */
    @Override
    public void addPOI(POI poi) {
    }

    /**
     * @return The currently visited POI.
     */
    @Override
    public POI getCurrent() {
        return null;
    }

    /**
     * Visits the next POI and returns the current one, which is removed from the tour.
     * Throws an EmptyTourException if the tour is empty.
     *
     * @return The POI that is currently being visited.
     */
    @Override
    public POI visitNext() {
        return null;
    }

    /**
     * Prints the current state of the tour to stdout.
     */
    @Override
    public void print() {

    }

    /**
     * @return The number of elements in this tour.
     */
    @Override
    public int count() {
        return 0;
    }
}
