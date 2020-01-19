package main.java.com.damo.concurrency;

public class Sync2 implements Runnable {
    static Sync2 t=new Sync2();
    static int i=0;

    private synchronized void  inc() {
        i++;
    }


    @Override
    public void run() {
        for(int j=0; j<10000000; j++){
            inc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(i);

    }
}
