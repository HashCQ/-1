package main.java.com.damo.concurrency;

import java.util.concurrent.*;

public class CallableExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec= Executors.newFixedThreadPool(3);

        CallableTask t=new CallableTask(1);
        Future<Integer> st=exec.submit(t);

        Integer result=st.get();
        System.out.println("Task's total sleep time:"+result+"seconds");
        exec.shutdown();


    }
}

class CallableTask implements Callable<Integer>{
    private int taskId;

    public CallableTask(int taskId){
        this.taskId=taskId;
    }


    @Override
    public Integer call() throws Exception {
        int total=taskId;

        System.out.println("Task #"+this.taskId);
        Thread.sleep(5000);

        total +=taskId;
        return total;
    }
}
