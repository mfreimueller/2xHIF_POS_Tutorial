package _2xhif.domain;

/**
 * A tour implementation that allows visitors to either visit the oldest or the youngest
 * POI from this tour.
 * Uses a double linked list to implement this feature.
 */
public class RandomTour implements Tour {

    // TODO: implement double linked list here!

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
     * @return The currently oldest POI of this tour.
     */
    @Override
    public POI getCurrent() {
        return null;
    }

    /**
     * Visits the next oldest POI of this tour and returns the currently oldest.
     * @return The oldest POI.
     */
    @Override
    public POI visitNext() {
        return null;
    }

    /**
     * Visits the next youngest POI of this tour.
     * @return The youngest POI.
     */
    public POI visitYoungest() {
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
