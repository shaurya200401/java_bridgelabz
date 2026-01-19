package DataStructures.LinkedList;

/**
 * Round Robin CPU Scheduling using Circular Linked List.
 * Simulates process execution with a time quantum.
 */
public class RoundRobinCll {

    static class ProcessNode {
        int processId;
        int burstTime;
        int priority;
        int remainingTime;
        ProcessNode next;

        public ProcessNode(int id, int burst, int priority) {
            this.processId = id;
            this.burstTime = burst;
            this.remainingTime = burst;
            this.priority = priority;
            this.next = null;
        }
    }

    private ProcessNode head;
    private ProcessNode tail;

    // Add process
    public void addProcess(int id, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(id, burst, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Process added: P" + id + " (Burst: " + burst + ")");
    }

    // Remove process
    public void removeProcess(int id) {
        if (head == null)
            return;

        ProcessNode current = head;
        ProcessNode prev = tail;

        if (current.processId == id) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        do {
            prev = current;
            current = current.next;
            if (current.processId == id) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
        } while (current != head);
    }

    // Simulate Round Robin
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        System.out.println("\nStarting Round Robin Scheduling (Quantum: " + timeQuantum + ")...");
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;

        // Count initial processes for average calculation
        int initialCount = 0;
        ProcessNode temp = head;
        if (head != null) {
            do {
                initialCount++;
                temp = temp.next;
            } while (temp != head);
        }

        ProcessNode current = head;
        // Since we are removing nodes, we run until head becomes null
        while (head != null) {
            // Execute current process
            boolean finished = false;
            int timeSlice = 0;

            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                timeSlice = timeQuantum;
            } else {
                timeSlice = current.remainingTime;
                current.remainingTime = 0;
                finished = true;
            }

            currentTime += timeSlice;
            System.out.println("Time " + currentTime + ": Process P" + current.processId + " executed for " + timeSlice
                    + " units. Remaining: " + current.remainingTime);

            if (finished) {
                int turnAroundTime = currentTime; // Assuming arrival time 0 for all
                int waitingTime = turnAroundTime - current.burstTime;

                totalTurnAroundTime += turnAroundTime;
                totalWaitingTime += waitingTime;
                completedProcesses++;

                System.out.println("-> Process P" + current.processId + " Finished! TAT: " + turnAroundTime + ", WT: "
                        + waitingTime);

                ProcessNode toRemove = current;
                current = current.next; // Move to next before removing

                // If only one node left and we remove it, current becomes null/unstable if we
                // don't handle carefullly
                if (head == tail && head == toRemove) {
                    head = null;
                    tail = null;
                    current = null;
                } else {
                    removeProcess(toRemove.processId);
                }
            } else {
                current = current.next;
            }
        }

        System.out.println("\nSimulation Completed.");
        if (completedProcesses > 0) {
            System.out.println("Average Waiting Time: " + (double) totalWaitingTime / completedProcesses);
            System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / completedProcesses);
        }
    }

    public static void main(String[] args) {
        RoundRobinCll rr = new RoundRobinCll();
        // Assuming all arrive at Time 0
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 3);

        rr.simulate(3);
    }
}
