package javaMultiThreading;

import java.util.concurrent.CyclicBarrier;

public class Task5 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Все потоки достигли барьера");
        });

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Work2(cyclicBarrier));
            t.start();
        }
    }
}

class Work2 implements Runnable {

    private final CyclicBarrier barrier;
    Work2(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + " работает");
        System.out.println("Поток " + Thread.currentThread().getName() + " достиг барьера");
        System.out.println("Поток " + Thread.currentThread().getName() + " продолжил работу");
    }
}
