
/**
 * Write a description of class BSTNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSTNode<T extends Comparable>
{
    private T data;
    private BSTNode<T> left, right;
    public BSTNode (T d)
    {
        data = d;
    }
    public T getData()
    {
        return data;
    }
    public void setData(T d)
    {
        this.data = d;
    }
    public BSTNode<T> getLeft()
    {
        return left;
    }
    public void setLeft(BSTNode<T> n)
    {
        left = n;
    }
    public BSTNode<T> getRight()
    {
        return right;
    }
    public void setRight(BSTNode<T> n)
    {
        right = n;
    }
    
    @Override
    public String toString() {
        // this method is rather simple:
        // - if we have a left node, call ::toString of the left node
        // - then write the data of our current node to the string builder
        // - finally, if we have a right node, call ::toString of the right node
        // ... using this solution, we simply traverse the tree from left to right
        
        /*
         *       2
         *     1   3
         *           4
         *             5
         *             
         * ... we start at 2, which has 1 as left node: "1"
         * ... then we write 2: "12"
         * ... then we go to the right (3), which has no left node, thus we write the value: "123"
         * ... then we go the the right (4), which has no left node, thus we write the value: "1234"
         * ... then we go the the right (5), which has no left node, thus we write the value: "12345"
         * ... having reached this point, we call "return sb.toString();", which returns us back to the first call (2) and then return the string
         */
        
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.toString());
        }
        
        sb.append(data);
        
        if (right != null) {
            sb.append(right.toString());
        }
        
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        // naturally we only compare apples to apples
        if (other instanceof BSTNode node) {
            // entry check: do both nodes contain the same data? If not, the tree cannot be identical
            if (!data.equals(node.data)) {
                return false;
            }
            
            // if we have a node to our left, recursively call equals on this left node
            if (left != null) {
                if (!left.equals(node.left)) {
                    return false;
                }
            } else if (node.left != null) {
                // otherwise: if we don't have a left node, but the other one does, the trees differ: not similar!
                return false;
            }
            
            // Spielt denselben Song nochmal. (this time from the right)
            if (right != null) {
                if (!right.equals(node.right)) {
                    return false;
                }
            } else if (node.right != null) {
                return false;
            }
            
            // the beauty of this solution is that we only checked for differences. If, at any point, one ::equals method
            // returned false, we bailed out. Only when all ::equals methods returned true, will we reach this exact point
            // and simply return true.
            
            return true;
        }
        
        return false;
    }
    
    public String getLeafNodes() {
        // to detect the leaf nodes, we recursively traverse our tree until we reach any node that has no left or right node
        // ... this must be a leaf nodes, which we return
        if (left == null && right == null) {
            return data.toString();
        }
        
        // otherwise we call ::getLeafNode on the left and right nodes and return the resulting string
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.getLeafNodes());
        }
        
        if (right != null) {
            sb.append(right.getLeafNodes());
        }
        
        return sb.toString();
    }
}
