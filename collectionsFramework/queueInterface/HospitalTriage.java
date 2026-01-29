package collectionsFramework.queueInterface;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class simulates a Hospital Triage System using a PriorityQueue.
 * Patients with higher severity (represented by a higher integer value) are
 * served first.
 */
public class HospitalTriage {

    // Patient class implementing Comparable is one way,
    // but using a custom Comparator gives more flexibility.
    static class Patient {
        String name;
        int severity; // Higher number means higher priority

        public Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {
        // Create a PriorityQueue with a custom comparator
        // We want descending order of severity (Max-Heap equivalent logic)
        // so (p1, p2) -> p2.severity - p1.severity
        Queue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        // Add patients
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5)); // Highest priority
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Patients in Triage (Internal Order may vary): " + triageQueue);
        System.out.println("\nTreating patients based on severity:");

        // Process patients
        while (!triageQueue.isEmpty()) {
            Patient currentPatient = triageQueue.poll();
            System.out.println("Treating: " + currentPatient);
        }
    }
}
