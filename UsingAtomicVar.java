package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class UsingAtomicVar {
    static AtomicInteger at = new AtomicInteger(0);

    public static void increaseVal() {
        for (int j = 0; j < 10000; j++) {
            at.incrementAndGet();
        }
    }

    static class Threadfun extends Thread {
        @Override
        public void run() {
            increaseVal();
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Threadfun();
        Thread t2 = new Threadfun();
        Thread t3 = new Threadfun();

        t1.start();
        t2.start();
        t3.start();

        int ret = at.get();
        System.out.println(+ret);
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
        }
        System.out.println("The value is" + at.get());
    }



}
