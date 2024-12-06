package javaMultiThreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 20; i++) {
            final int num = i;
            ex.submit(() -> {
                System.out.println("Номер потока: " + Thread.currentThread().getName() + "\n Номер задачи: " + num);
            });
        }
        ex.shutdown();
    }
}
