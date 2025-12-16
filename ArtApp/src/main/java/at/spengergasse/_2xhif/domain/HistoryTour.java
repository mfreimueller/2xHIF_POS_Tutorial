package at.spengergasse._2xhif.domain;

import at.spengergasse._2xhif.foundation.LinkedListNode;
import at.spengergasse._2xhif.foundation.exception.DuplicatedEntryException;
import at.spengergasse._2xhif.foundation.exception.EmptyTourException;

/**
 * Tour uses a linked lists to store a list of POIs that visitors are to visit.
 * This class only supports moving from POI to POI in the given order.
 * POIs are sorted by their year, where the oldest POI is visited first and the youngest last.
 */
public class HistoryTour implements Tour {

    // TODO: implement linked list here!
    // 1 -> 2 -> 3 -> ... -> null
    private LinkedListNode<POI> root;

    /**
     * Adds a new POI to the tour. If the POI is already part of the Tour, a DuplicatedEntryException
     * is to be thrown. The POI is inserted into the tour correctly by sorting it using getYear().
     *
     * @param poi A POI to add to the tour.
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

        // easiest case: the list is empty -> create root element
        if (root == null) {
            root = new LinkedListNode<>(poi);
            return;
        }

        final LinkedListNode<POI> newNode = new LinkedListNode<>(poi);

        // example: if 1530 > 1412, insert the new node as new root!
        if (root.getElement().getYear() > poi.getYear()) {
            newNode.setNext(root);
            root = newNode;

            return;
        }

        // same logic as below using arrays:
        // array: [1530; 1701; 1723] - too small, need to regrow and reinsert all elements
        // new array: [null; null; null; null]
        // before insert: [1530; 1701; 1723; null]
        // after insert: [1530; 1701; 1712; 1723]

        // example: add 1712
        // given: 1530 -> 1701 -> 1723 -> ...
        // expected: 1530 -> 1701 -> (*)1712 -> 1723 -> ...
        LinkedListNode<POI> cur = root;
        while (cur.getNext() != null) {
            final POI p = cur.getNext().getElement();

            // example: if 1723 > 1712, insert the new node here!
            if (p.getYear() > poi.getYear()) {
                newNode.setNext(cur.getNext());

                cur.setNext(newNode);

                return;
            }

            cur = cur.getNext();
        }

        // example: add 2025
        // given: 1530 -> 1701 -> 1723 -> ...
        // expected: 1530 -> 1701-> 1723 -> ... -> (*)2025
        cur.setNext(newNode);
    }

    /**
     * @return The currently visited POI.
     */
    @Override
    public POI getCurrent() {
        return root == null ? null : root.getElement();
    }

    /**
     * Visits the next POI and returns the current one, which is removed from the tour.
     * Throws an EmptyTourException if the tour is empty.
     *
     * @return The POI that is currently being visited.
     */
    @Override
    public POI visitNext() {
        if (root == null) {
            throw new EmptyTourException("The tour is empty and no POI can be visited next.");
        }

        final POI current = root.getElement();
        // old: 1530 -> 1701 -> 1723 -> ...
        // new: 1701 -> 1723 -> ...

        root = root.getNext();

        return current;
    }

    /**
     * Prints the current state of the tour to stdout.
     */
    @Override
    public void print() {
        final StringBuilder sb = new StringBuilder();

        LinkedListNode<POI> cur = root;
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

        // list:  1530 -> 1701 -> 1723 -> null
        // count: 1 -> 2 -> 3
        LinkedListNode<POI> cur = root;
        while (cur != null) {
            count++;
            cur = cur.getNext();
        }

        return count;
    }

    /**
     * Searches for a POI and returns true if the POI is part of this tour, otherwise false.
     */
    private boolean contains(POI poi) {
        // redundant: already checked via while-condition below
        //if (root == null) {
        //    return false;
        //}

        LinkedListNode<POI> cur = root;
        while (cur != null) {
            if (cur.getElement() == poi) {
                return true;
            }

            cur = cur.getNext();
        }

        return false;
    }
}
