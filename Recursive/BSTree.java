/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSTree<T extends Comparable>
{
    private BSTNode<T> root;
    public boolean add(T d)
    {
        BSTNode<T> n = new BSTNode(d);
        if (root == null)
        {
            root = n;
            return true;
        }
        else return add2(root,n);
    }

    private boolean add2(BSTNode<T> currNode, BSTNode<T> newNode)
    {
        if (currNode.getData().compareTo(newNode.getData()) >= 0)
        {
            if (currNode.getLeft() == null)
            {
                currNode.setLeft(newNode);
                return true;
            }
            else return add2(currNode.getLeft(),newNode);
        }
        else
        {
            if (currNode.getRight() == null)
            {
                currNode.setRight(newNode);
                return true;
            }
            else return add2(currNode.getRight(),newNode);
        }        
    }

    @Override
    public String toString()
    {
        // we override the ::toString method in BSTNode, as we want to create the string respresentation via
        // recursion (any other solution is less than optimal)
        return root == null ? "" : root.toString();
    }
    @Override
    public boolean equals(Object o)
    {
        // equality checks are easiest done via using recursion and the ::equals method of the BSTNode itself
        if (o instanceof BSTree tree) {
            // naive version:
            // return toString().equals(tree.toString());
            
            // pro version:
            return root.equals(tree.root);
        }
        
        return false;
    }
    public void add(BSTree<T> tr)
    {
        // when adding another tree to the current tree, we simply pass the root object of the other tree
        //  to our ::add2 method, because the method recursively calls ::add2 for any left and right nodes
        add2(root, tr.root);
    }
    public T max()
    {
        // given the nature of a binary search tree, the highest value must be on the outmost right node
        // (or, given that there are no right nodes, it must be the root node)
        // ... thus we simply traverse our tree from root to the right, until there is no next right node
        // ... having reached this point, we know that we've reached the highest value
        
        /*
         *       2
         *     1   3
         *           4
         *             5 <-- the node on the right must have the highest data
         */
        
        if (root == null) {
            throw new IllegalStateException("The tree is empty!");
        }
        
        BSTNode<T> right = root;
        while (right.getRight() != null) {
            right = right.getRight();
        }
        
        return right.getData();
    }
    public String allLeafNodes()
    {
        return root == null ? "" : root.getLeafNodes();
    }
}
