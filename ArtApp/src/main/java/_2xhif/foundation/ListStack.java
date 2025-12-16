package _2xhif.foundation;

import at.spengergasse._2xhif.foundation.exception.EmptyStackException;

import java.util.ArrayList;
import java.util.List;

/**
 * A stack implementation using an internal list.
 */
public class ListStack<Element> {
    private final List<Element> elements;

    public ListStack() {
        this.elements = new ArrayList<>();
    }

    /**
     * Pushes a new element onto the stack.
     * @param o The element to push onto the stack.
     */
    public void push(Element o) {
        if (o == null) {
            throw new IllegalArgumentException("o must not be null!");
        }

        this.elements.add(o);
    }

    /**
     * Returns the top most element from the stack and removes it.
     * Throws an EmptyStackException if there is no element on the stack.
     * @return The top most element from the stack.
     */
    public Element pop() throws EmptyStackException {
        // if (elements.size() == 0) {
        if (elements.isEmpty()) {
            throw new EmptyStackException("stack must not be null in ::pop()");
        }

        return elements.removeLast();
        // return elements.remove(elements.size() - 1);
    }

    /**
     * Returns the top most element from the stack, if there is at least one
     * element stored on the stack.
     * @return The top most element of the stack; doesn't remove it from the stack.
     */
    public Element peek() {
        if (elements.isEmpty()) {
            return null;
        } else {
            return elements.getLast();
            // return elements.get(elements.size() - 1); // []
        }
    }
}
