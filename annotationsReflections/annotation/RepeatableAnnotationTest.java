package annotationsReflections.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Exercise 5: Create and Use a Repeatable Annotation
 * Problem Statement:
 * Define an annotation @BugReport that can be applied multiple times on a method.
 * Steps:
 * 1. Define @BugReport with a description field.
 * 2. Use @Repeatable to allow multiple bug reports.
 * 3. Apply it twice on a method.
 * 4. Retrieve and print all bug reports.
 */

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Repeatable annotation
@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@interface BugReport {
    String description();

    String assignedTo() default "Unassigned";
}

/*
 * Class using repeatable annotations
 */
public class RepeatableAnnotationTest {

    @BugReport(description = "NullPointerException on startup", assignedTo = "Alice")
    @BugReport(description = "UI glitch on hover", assignedTo = "Bob")
    public void buggyMethod() {
        System.out.println("Executing buggy method...");
    }

    public static void main(String[] args) {
        try {
            BugReport[] reports = RepeatableAnnotationTest.class
                    .getMethod("buggyMethod")
                    .getAnnotationsByType(BugReport.class);

            for (BugReport report : reports) {
                System.out.println("Bug: " + report.description() + " | Assigned To: " + report.assignedTo());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
