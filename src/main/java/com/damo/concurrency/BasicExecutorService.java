package main.java.com.damo.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutorService {
    public static void main(String[] args) {
        final  int Thread=3;
        final  int Loop=3;
        final  int Task=5;

        ExecutorService exec= Executors.newFixedThreadPool(Thread);

        for (int i=1;i<=Task;i++){
            BasicTask task=new BasicTask(i,Loop);
            exec.submit(task);
        }
        exec.shutdown();
    }
}

class BasicTask implements Runnable{
    private int taskId;
    private int loopCount;

    public BasicTask(int taskId,int loopCount){
        this.taskId=taskId;
        this.loopCount=loopCount;
    }

    @Override
    public void run() {
        for (int i=1;i<=loopCount;i++){
            try {
                System.out.println("Task #"+this.taskId+"- iteration #"+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task #"+this.taskId+"stopped");
                break;

            }
        }

    }
}
