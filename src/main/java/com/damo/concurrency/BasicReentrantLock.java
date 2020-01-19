package main.java.com.damo.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class BasicReentrantLock implements Runnable {
    private  static ReentrantLock lock=new ReentrantLock();
    public static int i=0;



    @Override
    public void run() {
       for (int j=0;j<10000000;j++){
           lock.lock();
           try{
               i++;
           }finally {
               lock.unlock();
           }
       }
    }


    public static void main(String[] args) throws InterruptedException {
        BasicReentrantLock rl =new BasicReentrantLock();
        Thread t1=new Thread(rl);
        Thread t2=new Thread(rl);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
