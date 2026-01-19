package DataStructures.LinkedList;

/**
 * Task Scheduler using Circular Linked List.
 * Tasks loop in a circular manner.
 */
public class TaskSchedulerCll {

    static class TaskNode {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        TaskNode next;

        public TaskNode(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private TaskNode head;
    private TaskNode tail; // Keeping tail makes insertion at end O(1)

    // Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
        System.out.println("Task added at beginning: " + name);
    }

    // Add task at end
    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Task added at end: " + name);
    }

    // Add task at position
    public void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        TaskNode temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
        System.out.println("Task added at position " + pos);
    }

    // Remove task by ID
    public void removeTaskById(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        TaskNode current = head;
        TaskNode prev = tail;

        // Check if head is the node
        if (current.taskId == id) {
            if (head == tail) { // Only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Task removed: ID " + id);
            return;
        }

        // Search rest
        do {
            prev = current;
            current = current.next;
            if (current.taskId == id) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                System.out.println("Task removed: ID " + id);
                return;
            }
        } while (current != head);

        System.out.println("Task with ID " + id + " not found.");
    }

    // View current task and move to next
    private TaskNode currentTask;

    public void viewAndMove() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        if (currentTask == null)
            currentTask = head;

        System.out.println("Current Task: " + currentTask.taskName + " (ID: " + currentTask.taskId + ")");
        currentTask = currentTask.next;
    }

    // Display all
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        TaskNode temp = head;
        System.out.println("Tasks List:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No tasks with priority " + priority + " found.");
    }

    public static void main(String[] args) {
        TaskSchedulerCll scheduler = new TaskSchedulerCll();
        scheduler.addAtEnd(1, "Fix Bugs", 1, "2023-10-25");
        scheduler.addAtEnd(2, "Write Docs", 2, "2023-10-26");
        scheduler.addAtBeginning(3, "Meeting", 1, "2023-10-25");

        scheduler.displayAll();

        scheduler.viewAndMove(); // Meeting
        scheduler.viewAndMove(); // Fix Bugs
        scheduler.viewAndMove(); // Write Docs
        scheduler.viewAndMove(); // Meeting (Circular)

        scheduler.removeTaskById(2);
        scheduler.displayAll();
    }
}
