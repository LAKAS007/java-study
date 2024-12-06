package javaMultiThreading;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;

import static javaMultiThreading.Task7.factorial;

public class Task7 {



    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Map<Integer, Long> map = new ConcurrentHashMap<>();

        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
//            ex.submit(new FutureTask<>(new Work7(8L)));
            Future<Long> submit = ex.submit(new Work7(8L));
            System.out.println(submit.get());
        }
        ex.shutdown();
        ex.awaitTermination(1000, TimeUnit.MILLISECONDS);


    }
    public static Long factorial(Long num) {
        if (num == 0 || num == 1) {
            return 1L;
        }
        return factorial(num -1) * num;
    }
}

class Work7 implements Callable<Long> {

    Long fact;

    public Work7(Long fact) {
        this.fact = fact;
    }

    @Override
    public Long call() throws Exception {
        return factorial(fact);
    }
}

