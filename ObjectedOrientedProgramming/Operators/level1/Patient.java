package Operators.level1;

/*
 * Patient Class
 * Manages patient admission in a hospital.
 * Uses static hospital name and final patient ID.
 */
public class Patient {
    static String hospitalName = "City General Hospital"; // Shared hospital name
    static int totalPatients = 0;

    final String patientID; // Immutable ID
    String name;
    int age;
    String ailment;

    // Constructor
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    public void displayPatientDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("P-1001", "David", 45, "Flu");

        // Instanceof check
        if (p1 instanceof Patient) {
            p1.displayPatientDetails();
        }

        Patient.getTotalPatients();
    }
}
