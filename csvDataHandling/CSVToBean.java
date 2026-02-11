package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 9. Convert CSV Data into Java Objects
 * Reads a CSV file and converts each row into a Student Java object.
 * Stores the objects in a List<Student> and prints them.
 */
public class CSVToBean {
    // Static inner class for Student
    static class Student {
        private String id;
        private String name;
        private int age;
        private int marks;

        public Student(String id, String name, int age, int marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
        }
    }

    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    try {
                        String id = columns[0].trim();
                        String name = columns[1].trim();
                        int age = Integer.parseInt(columns[2].trim());
                        int marks = Integer.parseInt(columns[3].trim());

                        students.add(new Student(id, name, age, marks));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid row: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print all students
        System.out.println("Converted Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
