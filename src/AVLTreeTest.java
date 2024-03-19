import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.AVLTree;

public class AVLTreeTest {
	
    AVLTree<Integer> tree = new AVLTree<>();

	@Test
    public void testInsert1() {
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        assertEquals(3, tree.getSize());
    }
	
	@Test
    public void testInsert2() {
        tree.insert(10);
        tree.insert(10);
        assertEquals(1, tree.getSize()); 
    }

	@Test
    public void testSearch1() {
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        assertTrue(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
        assertFalse(tree.search(20)); // Not inserted
    }
	
	@Test
    public void testSearch2() {
        int[] values = {5, 15, 25, 35, 65, 75};		//In a Complex Tree
        for (int value : values) {
            tree.insert(value);
        }
        for (int value : values) {
            assertTrue("Failed to find " + value, tree.search(value));
        }
        assertFalse(tree.search(0));
        assertFalse(tree.search(40));
        assertFalse(tree.search(80));
    }
    
    
}