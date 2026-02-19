package annotationsReflections.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * PROBLEM: Custom Logging Proxy Using Reflection
 * Problem Statement:
 * Implement a Dynamic Proxy that intercepts method calls on an interface 
 * (e.g., Greeting.sayHello()) and logs the method name before executing it.
 * Concepts Tested:
 *  java.lang.reflect.Proxy
 *  InvocationHandler interface
 */

// Interface
interface Greeting {
    void sayHello(String name);
}

// Real Implementation
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Invocation Handler
class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[LOG] Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting realGreeting = new GreetingImpl();

        // Create Proxy
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[] { Greeting.class },
                new LoggingHandler(realGreeting));

        // Call method on proxy
        proxyGreeting.sayHello("Java Reflection");
    }
}
