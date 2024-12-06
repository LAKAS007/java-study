package javaMultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task2 {
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void addNumber(Integer number) {
        list.add(number);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] tPool = new Thread[10];
        for (int i = 0; i < 10; i++) {
            tPool[i] = new Thread(new MyRunnable2());
            tPool[i].start();
        }

        for (Thread thread : tPool) {
            thread.join();
        }
        System.out.println(list.size());

    }
}




class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Task2.addNumber(i);
        }
    }
}
