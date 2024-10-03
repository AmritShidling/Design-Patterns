package thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable r = ()->{
//            for (int i = 0; i < 10 ;i++) System.out.println("HI");
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(r);

        Callable callable = () ->{
            int total = 0;
            for(int i = 0; i < 10; i++) total += i;
            return total;
        };

        Future<Integer> future = executorService.submit(callable);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
