package _2xhif.domain;

public interface Tour {
    /**
     * Adds a new POI to the tour. If the POI is already part of the Tour, a DuplicatedEntryException
     * is to be thrown. The POI is inserted into the tour correctly by sorting it using getYear().
     *
     * @param poi A POI to add to the tour.
     */
    void addPOI(POI poi);

    /**
     * @return The currently visited POI.
     */
    POI getCurrent();

    /**
     * Visits the next POI and returns the current one, which is removed from the stack.
     * Throws an EmptyTourException if the tour has no next POI.
     *
     * @return The POI that is currently being visited.
     */
    POI visitNext();

    /**
     * Prints the current state of the tour to stdout.
     */
    void print();

    /**
     * @return The number of elements in this tour.
     */
    int count();

}
