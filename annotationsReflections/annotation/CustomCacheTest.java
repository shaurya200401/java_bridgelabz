package annotationsReflections.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem 7: Implement a Custom Caching System with @CacheResult
 * Problem Statement:
 * Define @CacheResult to store method return values and avoid repeated execution.
 * Requirements:
 * 1. Apply @CacheResult to a computationally expensive method.
 * 2. Implement a cache (HashMap) to store previously computed results.
 * 3. If method is called with the same input, return cached result instead of re-computation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

/*
 * Service with expensive operation
 */
class CalculationService {

    @CacheResult
    public int square(int number) {
        System.out.println("Computing square of " + number + " (Expensive Operation)...");
        try {
            Thread.sleep(1000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}

/*
 * Main class to simulate caching
 */
public class CustomCacheTest {

    // Cache: Map<MethodName + Arguments, Result>
    private static Map<String, Object> cache = new HashMap<>();

    public static Object invoke(Object service, String methodName, int arg) {
        try {
            Method method = service.getClass().getMethod(methodName, int.class);
            String cacheKey = methodName + ":" + arg;

            // Check if method is annotated
            if (method.isAnnotationPresent(CacheResult.class)) {
                if (cache.containsKey(cacheKey)) {
                    System.out.println("Returning cached result for input: " + arg);
                    return cache.get(cacheKey);
                }
            }

            // Invoke method
            Object result = method.invoke(service, arg);

            // Store in cache if annotated
            if (method.isAnnotationPresent(CacheResult.class)) {
                cache.put(cacheKey, result);
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        CalculationService service = new CalculationService();

        System.out.println("--- First Call (5) ---");
        System.out.println("Result: " + invoke(service, "square", 5));

        System.out.println("\n--- Second Call (5) - Should be Cached ---");
        System.out.println("Result: " + invoke(service, "square", 5));

        System.out.println("\n--- Third Call (10) ---");
        System.out.println("Result: " + invoke(service, "square", 10));
    }
}
