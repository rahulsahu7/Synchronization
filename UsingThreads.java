package org.example;

public class UsingThreads {
    private static int val = 0;

    public static void incrementVal() {
        for(int j=0;j<100000;j++)
        {
            val++;
        }

    }

    public static void printVal() {
        System.out.println("The value is " + val);
    }

    static class ThreadUse extends Thread {
        @Override
        public void run() {

            incrementVal();
        }
    }

    public static void main(String[] args) {

        Thread t1 = new ThreadUse();
        Thread t2 = new ThreadUse();
        Thread t3 = new ThreadUse();



            t1.start();
            t2.start();
            t3.start();


            printVal();



    }
}
