package threadcreation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=1; i<=10; i++){
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " is executed by thread " + Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
