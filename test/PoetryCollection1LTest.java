import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Kernel-level unit tests for PoetryCollection1L. Tests basic kernel and
 * Standard methods.
 */
public class PoetryCollection1LTest {

    @Test
    public void testConstructorAndSizeClear() {
        PoetryCollection1L pc = new PoetryCollection1L();
        assertEquals("New collection should be empty", 0, pc.size());
        pc.addPoem("A", "alpha");
        assertEquals(1, pc.size());
        pc.clear();
        assertEquals(0, pc.size());
    }

    @Test
    public void testAddGetHasRemove() {
        PoetryCollection1L pc = new PoetryCollection1L();
        pc.addPoem("Sun", "Sunrise poem");
        assertTrue(pc.hasPoem("Sun"));
        assertEquals("Sunrise poem", pc.getPoem("Sun"));
        String removed = pc.removePoem("Sun");
        assertEquals("Sunrise poem", removed);
        assertFalse(pc.hasPoem("Sun"));
    }

    @Test
    public void testRemoveAnyAndSize() {
        PoetryCollection1L pc = new PoetryCollection1L();
        pc.addPoem("X", "x-content");
        pc.addPoem("Y", "y-content");
        int before = pc.size();
        assertTrue(before == 2);
        java.util.Map.Entry<String, String> e = pc.removeAny();
        assertNotNull(e);
        assertEquals(before - 1, pc.size());
    }

    @Test
    public void testNewInstanceTransferFrom() {
        PoetryCollection1L a = new PoetryCollection1L();
        a.addPoem("One", "first");
        a.addPoem("Two", "second");

        PoetryCollection b = a.newInstance();
        assertEquals(0, b.size());

        b.transferFrom(a);
        // after transfer a should be empty, b should have contents
        assertEquals(0, a.size());
        assertEquals(2, b.size());
        assertTrue(b.hasPoem("One"));
        assertTrue(b.hasPoem("Two"));
    }
}
