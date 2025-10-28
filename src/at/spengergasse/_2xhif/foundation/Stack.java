package at.spengergasse._2xhif.foundation;

public interface Stack {
    /**
     * Pushes a new element onto the stack.
     * @param o The element to push onto the stack.
     */
    void push(Object o);

    /**
     * Returns the top most element from the stack and removes it.
     * Throws an EmptyStackException if there is no element on the stack.
     * @return The top most element from the stack.
     */
    Object pop();

    /**
     * Returns the top most element from the stack, if there is at least one
     * element stored on the stack.
     * @return The top most element of the stack; doesn't remove it from the stack.
     */
    Object peek();
}
