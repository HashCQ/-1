package main.java.com.damo.concurrency;

import java.util.concurrent.*;

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString()+"is rejected");
    }
}

class MyMonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int delay;
    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.delay = delay;
    }

    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(String.format("[monitor] [%d%d] Active:%d,Completed:%d," + "Task:%d,isShutdown:%s," +
                            "isTerminated:%s",
                    this.executor.getPoolSize(),
                    this.executor.getCorePoolSize(),
                    this.executor.getActiveCount(),
                    this.executor.getCompletedTaskCount(),
                    this.executor.getTaskCount(),
                    this.executor.isShutdown(),
                    this.executor.isTerminated())
            );
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}



class  Worker implements Runnable{
    private String command;

    public Worker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start.Command");
        process();
        System.out.println(Thread.currentThread().getName()+"End");

    }

    private void process(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
    return this.command;
    }

}

public class BasicThreadPollExecutor {
    public static void main(String[] args) {


        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), threadFactory, rejectedHandler);

        MyMonitorThread monitorTask = new MyMonitorThread(pool, 3);
        Thread monitor = new Thread(monitorTask);
        monitor.start();

        for (int i=0;i<10;i++){
            pool.execute(new Worker("cmd"+i));
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorTask.shutdown();
    }
}
