

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BSTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BSTreeTest
{
    BSTree<Integer> t, t1, t2, t3;
    /**
     * Default constructor for test class BSTreeTest
     */
    public BSTreeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        t = new BSTree<Integer>();
        t.add(2);
        t.add(1);
        t.add(3);
        t1 = new BSTree<Integer>();
        t1.add(2);
        t1.add(1);
        t1.add(3);
        t3 = new BSTree<Integer>();
        t3.add(7);
        t3.add(4);
        t3.add(5);
        t2 = new BSTree<Integer>();
        t2.add(5);
        t2.add(2);
        t2.add(1);
        t2.add(4);
        t2.add(3);
        t2.add(0);
        t2.add(8);
        t2.add(7);
        t2.add(6);
        t2.add(9);    
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testAdd()
    {
        t.add(0);
        t.add(2);
        t.add(7);
        t.add(5);
        assertEquals("0122357",t.toString());
    }
    @Test
    public void testToString()
    {
        assertEquals("123",t.toString());
        assertEquals("0123456789",t2.toString());
    }

    @Test
    void testEquals()
    {
        assertTrue(t.equals(t1));
        assertTrue(t1.equals(t1));
        assertFalse(t1.equals(t2));
    }
    @Test
    void testAddTree()
    {
        t1.add(t3);
        assertEquals("123457",t1.toString());
    }    

    @Test
    void ensure_that_max_returns_correct_value() {
        assertEquals(9, t2.max());
    }
    
    @Test
    void ensure_that_max_throws_on_empty_tree() {
        // magic construct that invokes ::max via a lambda expression... will look into this next term
        assertThrows(IllegalStateException.class, () -> new BSTree<Integer>().max());
    }
    
    @Test
    void ensure_that_leaf_nodes_are_returned_properly() {
        assertEquals("0369", t2.allLeafNodes());
    }
}
