package javaGenerics;

import java.util.ArrayList;
import java.util.List;

/*
 * AI-Driven Resume Screening System
 * Concepts: Generic Classes, Generic Methods, Bounded Type Parameters, Wildcards
 * 
 * This program develops a system that processes resumes for different job roles 
 * (Software Engineer, Data Scientist, Product Manager) ensuring type safety.
 */

// Abstract class for JobRole
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return candidateName + " (" + experienceYears + " years) - " + this.getClass().getSimpleName();
    }
}

// Concrete Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int experience) {
        super(name, experience);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, int experience) {
        super(name, experience);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, int experience) {
        super(name, experience);
    }
}

// Generic class to process resumes
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }
}

// Main class
public class ResumeScreeningSystem {

    // Wildcard method to process resumes for any job role
    public static void processResumes(List<? extends JobRole> candidates) {
        System.out.println("Screening Candidates:");
        for (JobRole candidate : candidates) {
            String status = (candidate.getExperienceYears() >= 3) ? "Shortlisted" : "Rejected";
            System.out.println("- " + candidate + " -> " + status);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Software Engineer Candidates
        List<SoftwareEngineer> seList = new ArrayList<>();
        seList.add(new SoftwareEngineer("Alice", 5));
        seList.add(new SoftwareEngineer("Bob", 2));

        // Data Scientist Candidates
        List<DataScientist> dsList = new ArrayList<>();
        dsList.add(new DataScientist("Charlie", 4));
        dsList.add(new DataScientist("David", 1));

        // Product Manager Candidates
        List<ProductManager> pmList = new ArrayList<>();
        pmList.add(new ProductManager("Eve", 8));
        pmList.add(new ProductManager("Frank", 3));

        System.out.println("\n--- AI Resume Screening Results ---");

        // Note: processResumes expects List<? extends JobRole>.
        // Java generics are invariant, so List<SoftwareEngineer> is NOT a subtype of
        // List<JobRole>.
        // but it IS a subtype of List<? extends JobRole>.
        processResumes(seList);
        processResumes(dsList);
        processResumes(pmList);
    }
}
