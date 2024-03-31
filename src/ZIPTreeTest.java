import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.ZIPTree;


public class ZIPTreeTest {
	
    ZIPTree<Integer> tree = new ZIPTree<>();
    
    // insert tests
    @Test
    public void testInsert0() {
        tree.insert(5);
        assertTrue(tree.search(5));
    }

    @Test
    public void testInsert1() {
        for (int i = 10; i > 0; i--) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert2() {
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert3() {
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }
        for (int i = 0; i < 1000; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert4() {
        for (int i = 0; i > -10; i--) {
            tree.insert(i);
        }
        for (int i = -9; i < 0; i++) {
            assertTrue(tree.search(i));
        }
    }

    @Test
    public void testInsert5() {
        assertThrows(IllegalArgumentException.class, () -> {
            tree.insert(null);
        });
    }
    
    // Delete tests
    @Test
    public void testDeleteFromEmptyTree() {
        tree.delete(5);
        assertFalse(tree.search(5));
    }
    
    @Test
    public void testDeleteRootNode() {
        tree.insert(10);
        tree.delete(10);
        assertFalse(tree.search(10));
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testDeleteLeafNode() {
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.delete(20);
        assertFalse(tree.search(20));
        assertTrue(tree.search(15));
        assertTrue(tree.search(10));
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
