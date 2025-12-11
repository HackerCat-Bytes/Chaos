import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for secondary methods implemented in PoetryCollectionSecondary and
 * interactions between kernel + secondary methods.
 */
public class PoetryCollectionTest {

    @Test
    public void testHasPoemDoesNotMutate() {
        PoetryCollection1L pc = new PoetryCollection1L();
        pc.addPoem("Crave", "content");
        int sizeBefore = pc.size();
        assertTrue(pc.hasPoem("Crave"));
        assertEquals(sizeBefore, pc.size()); // ensure no state change
    }

    @Test
    public void testGetLatestPoemBehavior() {
        PoetryCollection1L pc = new PoetryCollection1L();
        assertNull("Empty collection should return null for getLatestPoem",
                pc.getLatestPoem());
        pc.addPoem("First", "f");
        assertEquals("First", pc.getLatestPoem());
        pc.addPoem("Second", "s");
        assertEquals("Second", pc.getLatestPoem());
    }

    @Test
    public void testUpdateAndToStringEquals() {
        PoetryCollection1L a = new PoetryCollection1L();
        a.addPoem("P", "old");
        a.updatePoem("P", "new");
        assertEquals("new", a.getPoem("P"));

        PoetryCollection1L b = new PoetryCollection1L();
        b.addPoem("P", "new");
        assertTrue(a.equals(b));
        assertEquals(a.toString(), b.toString());
    }

    @Test
    public void testEqualsDifferentContent() {
        PoetryCollection1L a = new PoetryCollection1L();
        PoetryCollection1L b = new PoetryCollection1L();
        a.addPoem("A", "1");
        b.addPoem("A", "2");
        assertFalse(a.equals(b));
    }
}
