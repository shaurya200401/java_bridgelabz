package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Problem 3: List Operations
 * This class manages a list of integers and includes methods to add, remove,
 * and get size.
 * Includes JUnit tests to verify list operations.
 */
class ListManager {
    // Adds an element to the list
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Removes an element from the list
    public void removeElement(List<Integer> list, int element) {
        // Removing explicit object instead of index
        list.remove(Integer.valueOf(element));
    }

    // Returns the size of the list
    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {

    // Test adding elements to the list
    @Test
    public void testAddElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertEquals(1, list.size(), "List size should be 1 after adding an element");
        assertTrue(list.contains(10), "List should contain the added element");
    }

    // Test removing elements from the list
    @Test
    public void testRemoveElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.addElement(list, 20);
        manager.removeElement(list, 10);
        assertEquals(1, list.size(), "List size should be 1 after removing an element");
        assertFalse(list.contains(10), "List should not contain the removed element");
    }

    // Test getting the size of the list
    @Test
    public void testGetSize() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        manager.addElement(list, 15);
        assertEquals(2, manager.getSize(list), "Size should be 2");
    }
}
