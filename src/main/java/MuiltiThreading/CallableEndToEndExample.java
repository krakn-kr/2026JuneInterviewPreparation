package MuiltiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableEndToEndExample {

    // 1. Define the Callable task
    // It implements Callable<V> where V is the return type (String in this case)
    private static class FetchDataTask implements Callable<String> {
        private final String apiEndpoint;

        public FetchDataTask(String apiEndpoint) {
            this.apiEndpoint = apiEndpoint;
        }

        @Override
        public String call() throws Exception {
            System.out.println("[Thread: " + Thread.currentThread().getName() + "] Fetching data from: " + apiEndpoint);

            // Simulate network latency (2 seconds)
            Thread.sleep(2000);

            // Simulating a condition where an exception might be thrown
            if (apiEndpoint == null || apiEndpoint.isEmpty()) {
                throw new IllegalArgumentException("API Endpoint cannot be empty!");
            }

            return "{ \"status\": \"success\", \"data\": \"Payload from " + apiEndpoint + "\" }";
        }
    }

    public static void main(String[] args) {
        // 2. Create an ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            System.out.println("[Main Thread] Submitting Callable task...");

            // 3. Submit the Callable task to the executor
            // This returns a Future object instantly (non-blocking)
            Callable<String> task = new FetchDataTask("https://api.example.com/v1/users");
            Future<String> future = executor.submit(task);

            System.out.println("[Main Thread] Task submitted. Doing other work while waiting...");

            // Simulate doing some work in the main thread
            while (!future.isDone()) {
                System.out.println("[Main Thread] Task is still processing... waiting 500ms");
                Thread.sleep(500);
            }

            // 4. Retrieve the result from the Future
            // future.get() is a blocking call; it waits until the task finishes.
            // It is highly recommended to use a timeout to prevent infinite blocking.
            System.out.println("[Main Thread] Attempting to fetch result...");
            String jsonResult = future.get(1, TimeUnit.SECONDS);

            System.out.println("[Main Thread] Success! Received result:\n" + jsonResult);

        } catch (TimeoutException e) {
            System.err.println("[Main Thread] Error: The task took too long to execute!");
        } catch (InterruptedException e) {
            System.err.println("[Main Thread] Error: Main thread was interrupted.");
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (ExecutionException e) {
            // If the call() method threw a checked exception, it gets wrapped inside an ExecutionException
            System.err.println("[Main Thread] Error: The task itself threw an exception: " + e.getCause().getMessage());
        } finally {
            // 5. ALWAYS shut down your ExecutorService to free system resources
            System.out.println("[Main Thread] Shutting down executor...");
            executor.shutdown();
        }
    }
}
