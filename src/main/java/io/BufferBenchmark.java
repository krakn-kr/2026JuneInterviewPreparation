package io;

import java.io.*;

public class BufferBenchmark {
    // We will create a 5 Megabyte file for testing
    private static final String FILE_NAME = "benchmark_test.dat";
    private static final int FILE_SIZE = 5 * 1024 * 1024;

    public static void main(String[] args) {
        try {
            createTestFile();

            System.out.println("Reading unbuffered (This might take a moment)...");
            long unbufferedTime = measureUnbuffered();
            System.out.println("Unbuffered read took: " + unbufferedTime + " ms");

            System.out.println("Reading buffered...");
            long bufferedTime = measureBuffered();
            System.out.println("Buffered read took: " + bufferedTime + " ms");

            System.out.println("\nConclusion: Buffered stream was roughly "
                    + (unbufferedTime / Math.max(1, bufferedTime)) + " times faster.");

            // Clean up the temporary file
            new File(FILE_NAME).delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Helper Methods ---

    private static void createTestFile() throws IOException {
        System.out.println("Generating 5MB test file...");
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for (int i = 0; i < FILE_SIZE; i++) {
                bos.write(0); // Write dummy zero-bytes
            }
        }
    }

    private static long measureUnbuffered() throws IOException {
        long startTime = System.currentTimeMillis();

        // Reading byte-by-byte directly from the hard drive
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            while (fis.read() != -1) {
                // Do nothing, just read the byte
            }
        }

        return System.currentTimeMillis() - startTime;
    }

    private static long measureBuffered() throws IOException {
        long startTime = System.currentTimeMillis();

        // Reading byte-by-byte from the 8KB RAM buffer
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            while (bis.read() != -1) {
                // Do nothing, just read the byte
            }
        }

        return System.currentTimeMillis() - startTime;
    }
}