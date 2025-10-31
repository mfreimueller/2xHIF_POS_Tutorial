package at.spengergasse._2xhif.foundation;

public class DoubleLinkedListNode<E> {
    private final E element;
    private DoubleLinkedListNode<E> next;
    private DoubleLinkedListNode<E> previous;

    public DoubleLinkedListNode(E element) {
        this.element = element;
    }

    public void setNext(DoubleLinkedListNode<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public DoubleLinkedListNode<E> getNext() {
        return next;
    }

    public void setPrevious(DoubleLinkedListNode<E> previous) {
        this.previous = previous;
    }

    public DoubleLinkedListNode<E> getPrevious() {
        return previous;
    }
}
