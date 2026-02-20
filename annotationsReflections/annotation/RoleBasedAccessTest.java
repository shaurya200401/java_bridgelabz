package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Problem 5: Implement a Role-Based Access Control with @RoleAllowed
 * Problem Statement:
 * Define a class-level annotation @RoleAllowed to restrict method access based on roles.
 * Requirements:
 * 1. @RoleAllowed("ADMIN") should only allow ADMIN users to execute the method.
 * 2. Simulate user roles and validate access before invoking the method.
 * 3. If a non-admin tries to access it, print Access Denied!
 * Note: Prompt says "class-level annotation", but usually RBAC is method-level.
 * "Define a class-level annotation... to restrict method access".
 * If it's class level, it applies to all methods? Or maybe the prompt meant method-level?
 * "Define a class-level annotation @RoleAllowed to restrict method access based on roles."
 * "Requirements: @RoleAllowed("ADMIN") should only allow ADMIN users to execute the method."
 * This wording is slightly contradictory. Usually "class-level" means @Target(ElementType.TYPE).
 * If I put it on the class, the check should be "does the class have this annotation?".
 * However, commonly RBAC is on methods.
 * I will support both or stick to Method as it makes more sense for "execute the method".
 * Re-reading: "Define a class-level annotation... @RoleAllowed("ADMIN") should only allow ADMIN users to execute the method."
 * This likely implies that if the CLASS is marked ADMIN, then its methods require ADMIN.
 * I will implement it as valid for both TYPE and METHOD for flexibility, but the logic will check usage.
 * Actually, let's stick to the prompt "class-level annotation... restrict method access".
 * So I will put it on the class.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@interface RoleAllowed {
    String value();
}

/*
 * Secure service requiring ADMIN role
 */
@RoleAllowed("ADMIN")
class AdminPanel {
    public void deleteUser() {
        System.out.println("User deleted.");
    }

    public void viewReports() {
        System.out.println("Viewing reports...");
    }
}

class GuestPanel {
    public void viewHomePage() {
        System.out.println("Welcome Guest!");
    }
}

/*
 * Main class to simulate RBAC
 */
public class RoleBasedAccessTest {

    // Simulate current user role
    static String currentUserRole = "USER";

    public static void accessMethod(Object service, String methodName) {
        try {
            Class<?> clazz = service.getClass();
            Method method = clazz.getMethod(methodName);

            // Check class-level annotation
            if (clazz.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(currentUserRole)) {
                    System.out.println(
                            "Access Denied for method: " + methodName + " (Requires " + roleAllowed.value() + ")");
                    return;
                }
            }

            // Check method-level annotation (if we added it, but prompt emphasized
            // class-level)
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!roleAllowed.value().equals(currentUserRole)) {
                    System.out.println(
                            "Access Denied for method: " + methodName + " (Requires " + roleAllowed.value() + ")");
                    return;
                }
            }

            // Execute if allowed
            method.invoke(service);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdminPanel adminPanel = new AdminPanel();
        GuestPanel guestPanel = new GuestPanel();

        System.out.println("Current User Role: " + currentUserRole);

        System.out.println("\nTrying to access AdminPanel.deleteUser:");
        accessMethod(adminPanel, "deleteUser");

        System.out.println("\nTrying to access GuestPanel.viewHomePage:");
        accessMethod(guestPanel, "viewHomePage");

        // Change role to ADMIN
        currentUserRole = "ADMIN";
        System.out.println("\n[Switched to ADMIN]");
        System.out.println("Trying to access AdminPanel.deleteUser:");
        accessMethod(adminPanel, "deleteUser");
    }
}
