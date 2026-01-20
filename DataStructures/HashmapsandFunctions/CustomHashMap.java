package DataStructures.HashmapsandFunctions;

/**
 * Class to implement a basic hash map.
 * It uses an array of linked lists to handle collisions using separate
 * chaining.
 */
public class CustomHashMap<K, V> {

    // Node class for the linked list
    private class Node {
        K key;
        V value;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int capacity;
    private int size;

    // Constructor to initialize the hash map
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    // specific hash function
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Method to put a key-value pair into the map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node head = buckets[bucketIndex];

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value; // Update value
                return;
            }
            head = head.next;
        }

        // Insert new node at the beginning of the list
        head = buckets[bucketIndex];
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
        size++;
    }

    // Method to get a value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        Node head = buckets[bucketIndex];

        // Search for the key in the linked list
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Key not found
    }

    // Method to remove a key-value pair
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        Node head = buckets[bucketIndex];
        Node prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                // Remove the node
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[bucketIndex] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }

        return null; // Key not found
    }

    // Method to check if map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of map
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>(10);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Value for 'Two': " + map.get("Two"));
        System.out.println("Size: " + map.size());

        map.remove("Two");
        System.out.println("Value for 'Two' after removal: " + map.get("Two"));
        System.out.println("Size after removal: " + map.size());
    }
}
