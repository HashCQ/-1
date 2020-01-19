package main.java.com.damo.concurrency;

public class Sync1 implements Runnable {
    static Sync1 t = new Sync1();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) ;
        {
            synchronized (t) {
                i++;
            }
        }
    }
        public static void main (String[]args) throws InterruptedException {
            Thread t1 = new Thread(t);
            Thread t2 = new Thread(t);

            t1.start();
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }