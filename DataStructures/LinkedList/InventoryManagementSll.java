package DataStructures.LinkedList;

/**
 * Inventory Management System using Singly Linked List.
 * Features: Add, Remove, Update, Search, Total Value, Sort (Merge Sort).
 */
public class InventoryManagementSll {

    static class ItemNode {
        String itemName;
        int itemId;
        int quantity;
        double price;
        ItemNode next;

        public ItemNode(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    private ItemNode head;

    // Add item at the beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }

    // Add item at the end
    public void addAtEnd(String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (head == null) {
            head = newNode;
            System.out.println("Item added at end.");
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Item added at end.");
    }

    // Add item at specific position (1-based)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Item added at position " + pos);
            return;
        }
        ItemNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Item added at position " + pos);
        }
    }

    // Remove item by ID
    public void removeItemById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item with ID " + id + " removed.");
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + id + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + id + " removed.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated for Item ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + id + " not found.");
    }

    // Search by ID or Name
    public void searchItem(String nameOrId) {
        ItemNode temp = head;
        boolean found = false;
        try {
            int id = Integer.parseInt(nameOrId);
            while (temp != null) {
                if (temp.itemId == id) {
                    printItem(temp);
                    found = true;
                }
                temp = temp.next;
            }
        } catch (NumberFormatException e) {
            // Search by Name
            while (temp != null) {
                if (temp.itemName.equalsIgnoreCase(nameOrId)) {
                    printItem(temp);
                    found = true;
                }
                temp = temp.next;
            }
        }
        if (!found)
            System.out.println("Item not found.");
    }

    private void printItem(ItemNode node) {
        System.out.println("ID: " + node.itemId + ", Name: " + node.itemName + ", Qty: " + node.quantity + ", Price: "
                + node.price);
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += (temp.quantity * temp.price);
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Display all
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    // Sorting - Merge Sort
    public void sortByName(boolean ascending) {
        head = mergeSort(head, "name", ascending);
        System.out.println("Sorted by Name (" + (ascending ? "Asc" : "Desc") + ").");
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, "price", ascending);
        System.out.println("Sorted by Price (" + (ascending ? "Asc" : "Desc") + ").");
    }

    private ItemNode mergeSort(ItemNode head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, criteria, ascending);
        ItemNode right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        ItemNode result;
        int comparison;

        if (criteria.equals("name")) {
            comparison = a.itemName.compareToIgnoreCase(b.itemName);
        } else {
            comparison = Double.compare(a.price, b.price);
        }

        if (ascending) {
            if (comparison <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b, criteria, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, criteria, ascending);
            }
        } else {
            if (comparison >= 0) {
                result = a;
                result.next = sortedMerge(a.next, b, criteria, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, criteria, ascending);
            }
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode head) {
        if (head == null)
            return head;
        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        InventoryManagementSll inv = new InventoryManagementSll();
        inv.addAtEnd("Laptop", 101, 5, 80000);
        inv.addAtEnd("Mouse", 102, 20, 500);
        inv.addAtBeginning("Keyboard", 103, 10, 1500);

        inv.displayInventory();

        inv.calculateTotalValue();

        inv.sortByName(true);
        inv.displayInventory();

        inv.sortByPrice(false);
        inv.displayInventory();

        inv.removeItemById(102);
        inv.displayInventory();
    }
}
