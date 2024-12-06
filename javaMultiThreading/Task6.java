package javaMultiThreading;

import java.util.concurrent.Semaphore;

public class Task6 {
    public static void main(String[] args) {
        Semaphore sema = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Work3(sema));
            thread.start();
        }
    }
}

class Work3 implements Runnable {
    private final Semaphore sem;

    Work3(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " пытается получить доступ к ресурсу");
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " получил доступ к ресурсу");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sem.release();
    }
}