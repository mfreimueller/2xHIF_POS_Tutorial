package _2xhif.foundation;

import at.spengergasse._2xhif.domain.POI;
import at.spengergasse._2xhif.foundation.exception.EmptyStackException;
import at.spengergasse._2xhif.foundation.exception.EmptyTourException;

/**
 * A class used by users to track their visited POIs. The navigator
 * stores POIs on a stack, which allows the visitors to "go back" to their
 * previous POIs (similar to the browser functionality).
 */
public class TourNavigator {
    private final ListStack<POI> stack;

    public TourNavigator() {
        // TODO: create a new stack
        this.stack = new ListStack<>();
    }

    /**
     * Adds a new POI to the existing stack of visited POIs.
     *
     * @param poi A point of interest that the user visited. Must NOT be null.
     */
    public void visit(POI poi) {
        if (poi == null) {
            throw new IllegalArgumentException("poi must NOT be null!");
        }

        this.stack.push(poi);
    }

    /**
     * Returns the visitor to the previously visited POI (if there is any). If there is no POI
     * on the internal stack, an EmptyTourException must be thrown.
     * @return The POI that was visited last.
     */
    public POI goBack() throws EmptyTourException {
//        if (this.stack.peek() == null) {
//            throw new EmptyTourException("No POIs are stored in the navigator!");
//        }

        try {
            return this.stack.pop();
        } catch (EmptyStackException e) {
            throw new EmptyTourException("No POIs are stored in the navigator!", e);
        }
    }

    /**
     * Returns the current location of the user. If the internal stack is empty, an EmptyTourException
     * must be thrown.
     * @return The POI the visitor is seeing currently.
     */
    public POI getCurrentLocation() throws EmptyTourException {
        // 2x + 4y == 2 * (x + 2y)
        final POI currentElement = this.stack.peek();

        if (currentElement == null) {
            throw new EmptyTourException("No POIs are stored in the navigator!");
        }

        return currentElement;
    }

    /**
     * Ends the current tour by removing all elements from the stack.
     */
    public void endTour() {
        // this.stack = new ListStack<>(); - doesn't work because this.stack is final

        // core idea:
        // my stack: 1, 2, 3, 4
        // my stack: 1, 2, 3
        // my stack: 1, 2
        // my stack: 1
        // my stack: <empty>

        while (this.stack.peek() != null) {
            try {
                this.stack.pop();
            } catch (EmptyStackException e) {
                throw new IllegalStateException("This shouldn't have happened...", e);
            }
        }
    }
}
