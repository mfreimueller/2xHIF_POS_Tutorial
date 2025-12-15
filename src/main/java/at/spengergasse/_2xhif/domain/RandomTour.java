package at.spengergasse._2xhif.domain;

import at.spengergasse._2xhif.foundation.DoubleLinkedListNode;
import at.spengergasse._2xhif.foundation.LinkedListNode;
import at.spengergasse._2xhif.foundation.exception.DuplicatedEntryException;
import at.spengergasse._2xhif.foundation.exception.EmptyTourException;

/**
 * A tour implementation that allows visitors to either visit the oldest or the youngest
 * POI from this tour.
 * Uses a double linked list to implement this feature.
 */
public class RandomTour implements Tour {

    // structure of "normal" linked list: 1530 -> 1701 -> 1723 -> null
    // structure of double linked list: null <- 1530 <-> 1701 <-> 1723 -> null

    // TODO: implement double linked list here!
    private DoubleLinkedListNode<POI> root; // first element

    /**
     * Adds a new POI to the tour. If the POI is already part of the Tour, a DuplicatedEntryException
     * is to be thrown. The POI is inserted into the tour correctly by sorting it using getYear().
     *
     * @param poi A POI to add to the tour. Must not be null.
     */
    @Override
    public void addPOI(POI poi) {
        if (poi == null) {
            throw new IllegalArgumentException("poi must no be null!");
        }

        // is the poi already part of this tour? - if yes: throw exception
        if (contains(poi)) {
            throw new DuplicatedEntryException(poi.getId());
        }

        // easiest case: no entries yet
        if (root == null) {
            root = new DoubleLinkedListNode<>(poi);
            return;
        }

        final DoubleLinkedListNode<POI> newNode = new DoubleLinkedListNode<>(poi);

        // example: if 1530 > (*)1412, insert the new node as new root!
        if (root.getElement().getYear() > poi.getYear()) {
            newNode.setNext(root); // 1412 -> 1530
            root.setPrevious(newNode); // 1412 <- 1530
            root = newNode; // new: null <- 1412 <-> 1530 -> null

            return;
        }

        // example: add 1712
        // given: null <- 1530 <-> 1701 <-> 1723 -> null
        // expected: null <- 1530 <-> 1701 <-> (*)1712 <-> 1723 -> null
        DoubleLinkedListNode<POI> cur = root;
        while (cur.getNext() != null) {
            final POI p = cur.getNext().getElement();

            // example: if 1723 > 1712, insert the new node here!
            if (p.getYear() > poi.getYear()) {
                newNode.setNext(cur.getNext()); // (*)1712 -> 1723
                cur.getNext().setPrevious(newNode); // (*)1712 <- 1723

                cur.setNext(newNode); // 1701 -> (*)1712
                newNode.setPrevious(cur); // 1701 <- (*)1712

                return;
            }

            cur = cur.getNext();
        }

        // example: add 2025
        // given: null <- 1530 <-> 1701 <-> 1723 -> null
        // expected: null <- 1530 <-> 1701 <-> 1723 <-> (*)2025 -> null
        cur.setNext(newNode); // 1723 -> (*)2025
        newNode.setPrevious(cur); // 1723 <- (*)2025
    }

    /**
     * @return The currently oldest POI of this tour.
     */
    @Override
    public POI getCurrent() {
        return root == null ? null : root.getElement();
    }

    /**
     * Visits the next oldest POI of this tour and returns the currently oldest.
     * Throws an EmptyTourException if the tour is empty.
     *
     * @return The oldest POI.
     */
    @Override
    public POI visitNext() {
        if (root == null) {
            throw new EmptyTourException("The tour is empty and no POI can be visited next.");
        }

        final POI current = root.getElement();
        // old: null <- 1530 <-> 1701 <-> 1723 -> null
        // new: null <- 1701 <-> 1723 -> null

        root = root.getNext(); // null <- 1701 <-> ...

        // careful: root.getNext() might return null...
        if (root != null) {
            root.setPrevious(null);
        }

        return current;
    }

    /**
     * Visits the next youngest POI of this tour.
     * Throws an EmptyTourException if the tour is empty.
     *
     * @return The youngest POI.
     */
    public POI visitYoungest() {
        if (root == null) {
            throw new EmptyTourException("The tour is empty and no POI can be visited next.");
        }

        final DoubleLinkedListNode<POI> tail = getTail(); // returns 1723
        final POI youngest = tail.getElement();
        // old: null <- 1530 <-> 1701 <-> 1723 -> null
        // new: null <- 1530 <-> 1701 -> null

        final DoubleLinkedListNode<POI> prev = tail.getPrevious();
        if (prev == null) { // scenario: null <- 1723 -> null
            root = null;
        } else {
            prev.setNext(null); // currently: 1701 <- 1723
            tail.setPrevious(null); // now: 1701 -> null
        }

        return youngest;
    }

    /**
     * Prints the current state of the tour to stdout.
     */
    @Override
    public void print() {
        final StringBuilder sb = new StringBuilder();

        DoubleLinkedListNode<POI> cur = root;
        while (cur != null) {
            sb.append("- ").append(cur.getElement()).append(",\n");
            cur = cur.getNext();
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }

    /**
     * @return The number of elements in this tour.
     */
    @Override
    public int count() {
        int count = 0;

        // list:  null <- 1530 <-> 1701 <-> 1723 -> null
        // count: 1 -> 2 -> 3
        DoubleLinkedListNode<POI> cur = root;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }

        return count;
    }

    private DoubleLinkedListNode<POI> getTail() {
        if (root == null) {
            return null;
        }

        DoubleLinkedListNode<POI> cur = root;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }

        return cur;
    }

    /**
     * Searches for a POI and returns true if the POI is part of this tour, otherwise false.
     */
    private boolean contains(POI poi) {
        DoubleLinkedListNode<POI> cur = root;
        while (cur != null) {
            if (cur.getElement() == poi) {
                return true;
            }

            cur = cur.getNext();
        }

        return false;
    }
}
