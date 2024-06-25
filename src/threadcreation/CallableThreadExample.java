package threadcreation;

import java.util.concurrent.*;

public class CallableThreadExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =   Executors.newFixedThreadPool(1);

        // create a callable task
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello from callable thread!";
            }
        };

        Future<String> future = executorService.submit(task);

        System.out.println(future.isDone());  // false
        Thread.sleep(1000);
        System.out.println(future.isDone());  // true
        String result = future.get();
        System.out.println(result);
        System.out.println(future.isDone());  // true
        executorService.shutdown();
    }
}
