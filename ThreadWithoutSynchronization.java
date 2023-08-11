package io.e6x.external;

public class ThreadWithoutSynchronization {

        private static int i = 0; // Shared variable
        private static final int NUM_THREADS = 4;
        private static final int INCREMENTS_PER_THREAD = 100000;

        public static void main(String[] args) {
            Thread[] threads = new Thread[NUM_THREADS];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new IncrementThread();
                threads[j].start();
            }

            // Busy-wait until all threads finish
            while (anyThreadRunning(threads)) {
                // Do nothing
            }

            System.out.println("Final value of i: " + i);
        }

        static boolean anyThreadRunning(Thread[] threads) {
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    return true;
                }
            }
            return false;
        }

        static class IncrementThread extends Thread {
            @Override
            public void run() {
                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
                    i++; // Increment the shared variable i
                }
            }
        }
    }


