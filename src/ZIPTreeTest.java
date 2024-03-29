import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.ZIPTree;


public class ZIPTreeTest {
	
    ZIPTree<Integer> tree = new ZIPTree<>();
    
    // insert tests
    @Test
    public void testInsertIntoEmptyTree() {
        tree.insert(5);
        assertTrue(tree.search(5));
    }

    @Test
    public void testInsertDuplicateKeys() {
        tree.insert(5);
        tree.insert(5);
        assertTrue(tree.search(5));
    }

    @Test
    public void testInsertDescendingOrder() {
        for (int i = 10; i > 0; i--) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsertAscendingOrder() {
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsertLargeNumbers() {
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsertNegativeNumbers() {
        for (int i = 0; i > -10; i--) {
            tree.insert(i);
        }
        for (int i = -9; i < 0; i++) {
            assertTrue(tree.search(i));
        }
    }


    @Test
    public void testInsertNullKey() {
        assertThrows(IllegalArgumentException.class, () -> {
            tree.insert(null);
        });
    }

    // efficiency tests 
    @Test
    public void testInsertMaxValue() {
        tree.insert(Integer.MAX_VALUE);
        assertTrue(tree.search(Integer.MAX_VALUE));
    }

    @Test
    public void testInsertMinValue() {
        tree.insert(Integer.MIN_VALUE);
        assertTrue(tree.search(Integer.MIN_VALUE));
    }
}
