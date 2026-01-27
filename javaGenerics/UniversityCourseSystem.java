package javaGenerics;

import java.util.ArrayList;
import java.util.List;

/*
 * Multi-Level University Course Management System
 * Concepts: Generic Classes, Wildcards, Bounded Type Parameters
 * 
 * This program demonstrates a system where different departments offer courses with 
 * different evaluation types (Exam, Assignment, Research), using generics to manage them.
 */

// Abstract class for CourseType
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseName + " (" + this.getClass().getSimpleName() + ")";
    }
}

// Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}

// Generic class to manage courses
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
        System.out.println("Added course: " + course.getCourseName());
    }

    public List<T> getCourses() {
        return courses;
    }
}

// Main class
public class UniversityCourseSystem {

    // Wildcard method to handle any type of course dynamically
    public static void displayCourses(List<? extends CourseType> courses) {
        System.out.println("Course List:");
        for (CourseType course : courses) {
            System.out.println("- " + course);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Exam-based courses
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Calculus I"));
        examCourses.addCourse(new ExamCourse("Physics 101"));

        // Assignment-based courses
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Software Engineering"));
        assignmentCourses.addCourse(new AssignmentCourse("Web Development"));

        // Research-based courses
        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Advanced AI Research"));
        researchCourses.addCourse(new ResearchCourse("Quantum Computing Thesis"));

        System.out.println("\n--- University Course Overview ---");
        displayCourses(examCourses.getCourses());
        displayCourses(assignmentCourses.getCourses());
        displayCourses(researchCourses.getCourses());
    }
}
