import static org.junit.Assert.*;

import org.junit.Test;

import edu.uwm.cs351.AVLTree;

public class AVLTreeTest {
	
    AVLTree<Integer> tree = new AVLTree<>();
    
    // testing empty AVL tree
    @Test
    public void testEmptyTree01() {
        assertTrue(tree.isEmpty()); 
    }

    @Test
    public void testEmptyTree02() {
        assertEquals(0, tree.getSize()); 
    }

    @Test
    public void testEmptyTree03() {
        assertFalse(tree.search(10)); 
    }

    @Test
    public void testEmptyTree04() {
        assertNull(tree.getHeight()); 
    }

    @Test
    public void testEmptyTree05() {
        tree.delete(5);
        assertTrue(tree.isEmpty());
    }

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
	
    @Test
    public void testDelete1() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.delete(70);
        assertEquals(2, tree.getSize());
        assertFalse(tree.search(70));
    }
    
    @Test
    public void testDelete2() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.delete(30);
        assertEquals(6, tree.getSize());
        assertFalse(tree.search(30));
        assertTrue(tree.search(20));
        assertTrue(tree.search(40));
    }
    
    
}