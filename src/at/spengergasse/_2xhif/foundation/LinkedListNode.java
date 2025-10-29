package at.spengergasse._2xhif.foundation;

public class LinkedListNode<E> {
    private final E element;
    private LinkedListNode<E> next;

    public LinkedListNode(E element) {
        this.element = element;
    }

    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public LinkedListNode<E> getNext() {
        return next;
    }
}
