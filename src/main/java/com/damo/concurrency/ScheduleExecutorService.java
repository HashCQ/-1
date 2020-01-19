package main.java.com.damo.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService sexec= Executors.newScheduledThreadPool(3);
        ScheduleTask t1=new ScheduleTask(1);
        ScheduleTask t2=new ScheduleTask(2);

        sexec.schedule(t1,5, TimeUnit.SECONDS);

        sexec.scheduleAtFixedRate(t2,0,10,TimeUnit.SECONDS);


        try {
            TimeUnit.SECONDS.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sexec.shutdown();

    }
}

class ScheduleTask implements Runnable{
    private int taskId;


    public ScheduleTask(int taskId){
        this.taskId=taskId;
    }

    @Override
    public void run() {
        LocalDateTime time=LocalDateTime.now();
        System.out.println("Task #"+this.taskId+"ran at"+time);

    }
}
