package org.example;

public class UsingSynchro {

        private static int val = 0;

        public static synchronized void incrementVal() {
            for(int j=0;j<100000;j++)
            {
                val++;
            }

        }//you need to do it in a loop because it has 3 Operations to perform before 1. Read 2.Operate 3.Write ANd thus here is where the Confusion occurs and wrong value is printed
//For synchronizing add the synchronized keyword in here
        public static void printVal() {
            System.out.println("The value is " + val);
        }

        static class  ThreadUse extends Thread {
            @Override
            public void run() {

                incrementVal();
            }
        }    //This is a class Required to create a Thread, You should override the function with a run

        public static void main(String[] args) {

            Thread t1 = new ThreadUse();
            Thread t2 = new ThreadUse();
            Thread t3 = new ThreadUse(); // We have used Class on the RHS



            t1.start();
            t2.start();
            t3.start();

            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                System.err.println("Main thread was interrupted.");
            }
            //Always use this before printing the value in which the changes are made


            printVal();



        }
    }


