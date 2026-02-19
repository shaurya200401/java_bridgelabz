package annotationsReflections.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

/*
 * PROBLEM: Dependency Injection using Reflection
 * Problem Statement:
 * Implement a simple DI container that scans classes with @Inject annotation 
 * and injects dependencies dynamically.
 * Concepts Tested:
 *  Custom Annotations
 *  Field Injection via Reflection
 */

// Define Inject annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

// Service to be injected
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

// Client class requiring injection
class Client {
    @Inject
    private Service service;

    public void doWork() {
        if (service != null) {
            service.serve();
        } else {
            System.out.println("Service is null!");
        }
    }
}

// Simple DI Container
class DIContainer {
    public static void injectDependencies(Object object) {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                try {
                    field.setAccessible(true);

                    // Instantiate the dependency (Assuming default constructor)
                    // In real DI, this would come from a bean pool/context.
                    Object dependency = field.getType().getDeclaredConstructor().newInstance();

                    field.set(object, dependency);
                    System.out.println("Injected " + field.getType().getSimpleName() + " into " + field.getName());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class DependencyInjection {
    public static void main(String[] args) {
        Client client = new Client();

        System.out.println("Before Injection:");
        client.doWork();

        System.out.println("\nPerforming Injection...");
        DIContainer.injectDependencies(client);

        System.out.println("\nAfter Injection:");
        client.doWork();
    }
}
