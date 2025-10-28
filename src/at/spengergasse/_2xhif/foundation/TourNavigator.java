package at.spengergasse._2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;

/**
 * A class used by users to track their visited POIs. The navigator
 * stores POIs on a stack, which allows the visitors to "go back" to their
 * previous POIs (similar to the browser functionality).
 */
public class TourNavigator {
    private ListStack stack;

    public TourNavigator() {
        // TODO: create a new stack
    }

    /**
     * Adds a new POI to the existing stack of visited POIs.
     *
     * @param poi A point of interest that the user visited. Must NOT be null.
     */
    public void visit(POI poi) {}

    /**
     * Returns the visitor to the previously visited POI (if there is any). If there is no POI
     * on the internal stack, an EmptyTourException must be thrown.
     * @return The POI that was visited last.
     */
    public POI goBack() {
        return null;
    }

    /**
     * Returns the current location of the user. If the internal stack is empty, an EmptyTourException
     * must be thrown.
     * @return The POI the visitor is seeing currently.
     */
    public POI getCurrentLocation() {
        return null;
    }

    /**
     * Ends the current tour by removing all elements from the stack.
     */
    public void endTour() {}
}
