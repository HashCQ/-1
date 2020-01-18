package main.java.com.damo.concurrency;

public class BasicThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new BasicRunnable(),"t1");
        Thread t2=new Thread(new BasicRunnable(),"t2");
        Thread t3=new Thread(new BasicRunnable(),"t3");

        t1.start();
        t1.join(5000);


        t2.start();
        t2.join(2000);

        t3.start();


        System.out.println("All thread done,exit main");
    }
}
