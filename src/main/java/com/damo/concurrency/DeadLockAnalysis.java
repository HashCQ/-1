package main.java.com.damo.concurrency;

public class DeadLockAnalysis {

    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Object o3=new Object();

        Thread t1=new Thread(new SyncThread(o1,o2),"t1");
        Thread t2=new Thread(new SyncThread(o2,o3),"t2");
        Thread t3=new Thread(new SyncThread(o3,o1),"t3");

        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();

        }

    }


    class SyncThread implements  Runnable {

    private Object o1;
    private Object o2;

    public SyncThread(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        String  name=Thread.currentThread().getName();
        System.out.println(name+"acquiring lock on"+o1);
        synchronized (o1){
            System.out.println(name+"acquiring lock on"+o1);
            work();
        }
        System.out.println(name+"released lock on"+o1);

        System.out.println(name+"acquiring lock on"+o2);
        synchronized (o2){
            System.out.println(name+"acquiring lock on"+o2);
            work();
        }
        System.out.println(name+"released lock on"+o2);

        System.out.println("Finished");

    }

    private void work(){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
