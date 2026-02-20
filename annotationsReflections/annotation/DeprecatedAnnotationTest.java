package annotationsReflections.annotation;

/*
 * Exercise 2: Use @Deprecated to Mark an Old Method
 * Problem Statement:
 * Create a class LegacyAPI with an old method oldFeature(), which should not be used anymore. Instead, introduce a new method newFeature().
 * Steps:
 * 1. Define a class LegacyAPI.
 * 2. Mark oldFeature() as @Deprecated.
 * 3. Call both methods and observe the warning.
 */
class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature.");
    }

    public void newFeature() {
        System.out.println("This is the new feature.");
    }
}

/*
 * Main class to test the @Deprecated annotation
 */
public class DeprecatedAnnotationTest {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // This should trigger a warning
        api.newFeature();
    }
}
