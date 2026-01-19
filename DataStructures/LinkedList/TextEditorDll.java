package DataStructures.LinkedList;

/**
 * Text Editor Undo/Redo functionality using Doubly Linked List.
 * Stores text states. Max history size: 10.
 */
public class TextEditorDll {

    static class StateNode {
        String content;
        StateNode prev;
        StateNode next;

        public StateNode(String content) {
            this.content = content;
        }
    }

    private StateNode head;
    private StateNode current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public TextEditorDll() {
        // Initial empty state
        head = new StateNode("");
        current = head;
        size = 1;
    }

    // Add a new state (User types something)
    public void addState(String newContent) {
        // If we are not at the end (current.next != null),
        // we cut off the forward history (standard text editor behavior)
        if (current.next != null) {
            deleteForwardHistory();
        }

        StateNode newNode = new StateNode(newContent);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        size++;

        // Enforce max history limit
        if (size > MAX_HISTORY) {
            removeOldestState();
        }
        System.out.println("State added: \"" + newContent + "\"");
    }

    private void deleteForwardHistory() {
        StateNode temp = current.next;
        while (temp != null) {
            temp = temp.next;
            size--;
        }
        current.next = null;
    }

    private void removeOldestState() {
        if (head != null && head.next != null) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Cannot Undo. At initial state.");
        }
        displayCurrentState();
    }

    // Redo
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Cannot Redo. At latest state.");
        }
        displayCurrentState();
    }

    // Display current text
    public void displayCurrentState() {
        System.out.println("Current Text: \"" + current.content + "\"");
    }

    public static void main(String[] args) {
        TextEditorDll editor = new TextEditorDll();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.undo(); // Hello World
        editor.undo(); // Hello

        editor.redo(); // Hello World

        editor.addState("Hello World Modified"); // Breaks redo chain to "Hello World!"

        editor.undo(); // Hello World
        editor.redo(); // Hello World Modified
        editor.redo(); // Cannot redo

        // Test limit
        for (int i = 0; i < 15; i++) {
            editor.addState("State " + i);
        }
    }
}
