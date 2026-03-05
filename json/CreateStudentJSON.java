package json;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Creates a JSON object for a Student.
 * Contains fields: name, age, and an array of subjects.
 */
public class CreateStudentJSON {
    public static void main(String[] args) {
        // Create new JSON object
        JSONObject student = new JSONObject();
        
        // Add basic fields
        student.put("name", "John Doe");
        student.put("age", 22);
        
        // Create JSON array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Physics");
        subjects.put("Computer Science");
        
        // Add array to student object
        student.put("subjects", subjects);
        
        // Print the created JSON string
        System.out.println("Student JSON:");
        System.out.println(student.toString(4));
    }
}
