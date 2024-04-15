import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.uwm.cs351.ZIPTree;
import edu.uwm.cs351.TreeInterface;

import static org.junit.Assert.*;

public class TestEfficiency {
    private static final int POWER = 20;
    private static final int MAX = 1 << POWER;
    private static final int TESTS = MAX / POWER;

    private TreeInterface<Integer> tree;
    private Integer[] items;
    private Random random;

    @Before
    public void setUp() {
        tree = new ZIPTree<>();
        items = new Integer[MAX];
        random = new Random();

        for (int i = 0; i < MAX; i++) {
            items[i] = i;
        }

        // Randomly insert items into the Zip Tree
        for (int i = 0; i < MAX; i++) {
            int index = random.nextInt(MAX - i);
            tree.insert(items[index]);
            items[index] = items[MAX - i - 1];
        }
    }

    @Test
    public void testSearch() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            assertTrue(tree.search(items[index]));
        }
    }

    @Test
    public void testInsert() {
        for (int i = 0; i < TESTS; i++) {
            int newItem = MAX + i;
            tree.insert(newItem);
            assertTrue(tree.search(newItem));
        }
    }

    @Test
    public void testDelete() {
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(MAX);
            tree.delete(items[index]);
            assertFalse(tree.search(items[index]));
        }
    }

    @Test
    public void testSize() {
        assertEquals(MAX, tree.getSize());
    }
}