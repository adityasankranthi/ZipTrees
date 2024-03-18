import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.AVLTree;

public class AVLTreeTest {

	@Test
    public void testInsert() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);
        assertEquals(3, tree.getSize());
    }
	@Test
    public void testSearch() {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(5);
        tree.insert(10);
        tree.insert(15);

        assertTrue(tree.search(5));
        assertTrue(tree.search(10));
        assertTrue(tree.search(15));
        assertFalse(tree.search(20)); // Not inserted
    }
    
    
}