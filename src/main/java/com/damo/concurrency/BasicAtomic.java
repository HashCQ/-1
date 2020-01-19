package main.java.com.damo.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class BasicAtomic {
    public static void main(String[] args) throws InterruptedException {
        Process pt = new Process();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");


        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }
}

class Process implements Runnable{
    private AtomicInteger count=new AtomicInteger();

    public AtomicInteger getCount() throws InterruptedException {
        Process pt = new Process();


        return count;
    }

    @Override
    public void run() {
        for (int i=0;i<10000000;i++){
            int current=count.incrementAndGet();
            System.out.println(Thread.currentThread().getName()+"count="+current);
        }
    }
}
