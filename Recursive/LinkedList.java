
/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<T>
{
    private LLNode<T> head;
    public boolean add(T element)
    {
        LLNode<T> n = new LLNode<T>(element);
        if (head == null)
        {
            head = n;
            return true;
        }
        else 
        {
            // the original line had a typo. You want to add 'n' as the new node, not the head to n
            // return add2(n, head);
            return add2(head, n);
        }
    }
    public boolean add2(LLNode<T> currNode, LLNode<T> newNode)
    {
        // as a linked list grows from the left and new nodes are always added to the right,
        // we must traverse the linked list until we reach the last node
        // remember: last node == node which has no next node
        if (currNode.getNext() != null) {
            return add2(currNode.getNext(), newNode);
        }
        
        // if we reach this point, we've reached the 'rightest' node and can set the new node as the
        // next (the new 'rightest') node
        currNode.setNext(newNode);
        return true;
    }
    @Override
    public boolean equals(Object o)
    {
        // basically we pass the burden of the equality check to the LLNode, because then we can process via recursion
        if (o instanceof LinkedList ll) {
            // easiest case: both heads are null - thus they must be identical
            if (head == null && ll.head == null) {
                return true;
            } else if (head != null) {
                // given that we implemented a null-check in LLNode::equals, we can pass the other linked lists head to the method
                // if the other head is null, it will return false, otherwise process further.
                return head.equals(ll.head);
            }
        }
        
        return false;
    }
    @Override
    public String toString()
    {
        // ::toString for a linked list is rather straight forward:
        // simply go from the head to the right until there is no more node on the right
        // ... and write the data for each node
        StringBuilder sb = new StringBuilder();
        
        LLNode<T> cur = head;
        
        // this condition makes sure that we go to the right until the next node is null, which marks the end of our list
        while (cur != null) {
            sb.append(cur.getData());
            
            // select the next node (which might be null - when? - whenever we've reached the end)
            cur = cur.getNext();
        }
        
        return sb.toString();
    }
    public int count(T element)
    {
        int c = 0;
        
        LLNode<T> cur = head;
        while (cur != null) {
            // if both data matches, increase our counter
            if (cur.getData().equals(element)) {
                c++;
            }
            cur = cur.getNext();
        }
        
        return c;
    }
    public LinkedList<T> intersection(LinkedList<T> ll)
    {
        LinkedList<T> intersect = new LinkedList<>();
        
        LLNode<T> thisCur = head;
        
        // we traverse our (this) list from left to right, until we reach the end
        while (thisCur != null) {
            LLNode<T> otherCur = ll.head;
            
            // then we traverse the other linked list from left to right
            while (otherCur != null) {
                // if both data matches, add it to the list
                if (thisCur.getData().equals(otherCur.getData())) {
                    intersect.add(thisCur.getData());
                    
                    // if we've found a match, we exit the inner loop (.. while (otherCur != null) { ...)
                    break;
                }
                
                otherCur = otherCur.getNext();
            }
            
            thisCur = thisCur.getNext();
        }
        
        return intersect;
    }
}
