package MuiltiThreading;

public class VolatilePoc {

    // STEP 1: Try running this first WITH volatile, then WITHOUT volatile.
    // CHANGE THIS TO: private static boolean stopRequested = false;
    private static volatile boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting POC on thread: " + Thread.currentThread().getName());

        // Reader Thread: Simulates a background worker checking a flag
        Thread readerThread = new Thread(() -> {
            System.out.println("Reader Thread started. Waiting for stopRequested to become true...");
            long count = 0;

            // This loop runs continuously until stopRequested is true
            while (!stopRequested) {
                count++;
                // Note: Keeping this loop entirely empty or putting a System.out.println
                // inside it can sometimes force a cache flush naturally. Leaving it
                // as a raw math counter isolates the CPU caching behavior perfectly.
            }

            System.out.println("Success! Reader Thread detected the change. Count reached: " + count);
        }, "Reader-Thread");

        // Writer Thread: Simulates an admin updating a setting after 1 second
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait 1 second
                System.out.println("\nWriter Thread: Updating stopRequested to true...");
                stopRequested = true;
                System.out.println("Writer Thread: Main memory updated.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Writer-Thread");

        // Start both threads
        readerThread.start();
        writerThread.start();

        // Wait for them to finish
        readerThread.join();
        writerThread.join();
        System.out.println("POC Finished.");
    }
}