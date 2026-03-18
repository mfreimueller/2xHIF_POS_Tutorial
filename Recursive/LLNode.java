
/**
 * Write a description of class LLNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LLNode<T>
{
    private T data;
    private LLNode<T> next;
    public LLNode(T data)
    {
        setData(data);
    }
    public T getData()
    {
        return data;
    }
    public void setData(T data)
    {
        this.data = data;
    }
    public LLNode<T> getNext()
    {
        return next;
    }
    public void setNext(LLNode<T> next)
    {
        this.next = next;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        if (other instanceof LLNode node) {
            if (data.equals(node.data)) {
                if (next != null) {
                    return next.equals(node.next);
                } else if (node.next == null) {
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return data + (next == null ? "" : next.toString());
    }
}
