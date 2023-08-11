package io.e6x.external;

public class ThreadWithSynchronization {

        private static int i = 0; // Shared variable
        private static final int NUM_THREADS = 4;
        private static final int ITERATIONS = 100000;

        public static void main(String[] args) {
            Thread[] threads = new Thread[NUM_THREADS];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new IncrementThread();
                threads[j].start();
            }

            // Wait for all threads to finish
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Print the final value of i
            System.out.println("Final value of i: " + i);
        }

        static class IncrementThread extends Thread {
            @Override
            public void run() {
                for (int j = 0; j < ITERATIONS; j++) {
                    synchronized (ThreadWithSynchronization.class) {
                        i++; // Increment the shared variable i within synchronized block
                    }
                }
            }
        }
    }


