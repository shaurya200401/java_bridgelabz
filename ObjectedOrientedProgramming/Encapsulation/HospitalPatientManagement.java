package Encapsulation;

import java.util.ArrayList;
import java.util.List;

/*
 * HospitalPatientManagement Class
 * Demonstrates encapsulation, abstraction, inheritance, and polymorphism.
 * Patient is the abstract superclass.
 * MedicalRecord is an interface.
 */
public class HospitalPatientManagement {

    interface MedicalRecord {
        void addRecord(String record);

        void viewRecords();
    }

    static abstract class Patient implements MedicalRecord {
        private String patientId;
        private String name;
        private int age;
        private List<String> medicalHistory; // Encapsulated medical history

        public Patient(String patientId, String name, int age) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
            this.medicalHistory = new ArrayList<>();
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public void addRecord(String record) {
            medicalHistory.add(record);
        }

        @Override
        public void viewRecords() {
            System.out.println("Medical History for " + name + ": " + medicalHistory);
        }

        public abstract double calculateBill(int days);

        public void getPatientDetails() {
            System.out.println("Patient ID: " + patientId);
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    static class InPatient extends Patient {
        private double roomCharges;

        public InPatient(String patientId, String name, int age, double roomCharges) {
            super(patientId, name, age);
            this.roomCharges = roomCharges;
        }

        @Override
        public double calculateBill(int days) {
            return roomCharges * days + 2000; // Room charges + Fixed admission fee
        }
    }

    static class OutPatient extends Patient {
        private double consultationFee;

        public OutPatient(String patientId, String name, int age, double consultationFee) {
            super(patientId, name, age);
            this.consultationFee = consultationFee;
        }

        @Override
        public double calculateBill(int days) {
            return consultationFee; // Flat fee for outpatient visit (days ignored usually, or maybe followups)
        }
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient("P101", "John Doe", 45, 500);
        p1.addRecord("Fever detected");
        p1.addRecord("Prescribed Paracetamol");

        OutPatient p2 = new OutPatient("P202", "Jane Smith", 30, 300);
        p2.addRecord("Routine Checkup");

        patients.add(p1);
        patients.add(p2);

        System.out.println("Hospital Management System:");
        for (Patient p : patients) {
            p.getPatientDetails();
            p.viewRecords();
            System.out.println("Total Bill: $" + p.calculateBill(3)); // Assuming 3 days for inpatient
            System.out.println("-------------------------");
        }
    }
}
