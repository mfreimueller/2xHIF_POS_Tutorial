

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LinkedListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LinkedListTest
{
    LinkedList<Integer> l1,l2, l3;
    /**
     * Default constructor for test class LinkedListTest
     */
    public LinkedListTest()
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
        l1 = new LinkedList<Integer>();
        l1.add(1);
        l1.add(3);
        l1.add(5);
        l2 = new LinkedList<Integer>();
        l2.add(1);
        l2.add(3);
        l2.add(5);
        l3 = new LinkedList<Integer>();
        l3.add(2);
        l3.add(4);
        l3.add(3);
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
    public void testEquals()
    {
        assertTrue(l1.equals(l2));
        l2.add(7);
        assertFalse(l1.equals(l2));
    }
    @Test
    public void testToString()
    {
        assertEquals("135",l1.toString());
    }
    @Test
    public void testIntersection()
    {
        assertEquals("3",l1.intersection(l3).toString());
        assertTrue(l1.intersection(l2).toString().length() == 3);
    }
    @Test
    public void ensure_that_count_returns_correct_value() {
        assertEquals(1, l1.count(3));
    }
}
