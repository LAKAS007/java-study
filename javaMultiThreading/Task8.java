package javaMultiThreading;

import java.time.temporal.TemporalUnit;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Task8 {

    private static BlockingQueue queue = new ArrayBlockingQueue<Integer>(10);


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    addToQueue();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
    }

    private static void addToQueue() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    private static Integer consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            queue.take();
            System.out.println("Size: " + queue.size());
            System.out.println(queue.toString());
        }
    }
}
