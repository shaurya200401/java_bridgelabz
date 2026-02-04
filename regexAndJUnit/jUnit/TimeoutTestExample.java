package regexAndJUnit.jUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

/**
 * Problem 7: Performance Testing Using @Timeout
 * This class includes a long-running method to demonstrate timeout failure.
 */
class TaskRunner {
    // Simulates a long running task
    public void longRunningTask() {
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TimeoutTestExample {

    // Test expected to pass
    // Using @Timeout(4) to allow execution if it completes within 4 seconds
    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    public void testLongRunningTask() {
        TaskRunner runner = new TaskRunner();
        runner.longRunningTask(); // This takes 3 seconds, so test will fail
    }
}
