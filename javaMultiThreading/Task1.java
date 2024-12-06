package javaMultiThreading;

public class Task1 {
    private static int cnt;

    public synchronized static void increment() {
        cnt++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] tPool = new Thread[5];
        for (int i = 0; i < 5; i++) {
            tPool[i] = new Thread(new MyRunnable());
            tPool[i].start();
        }

        for (Thread thread : tPool) {
            thread.join();
        }
        System.out.println(cnt);

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Task1.increment();
        }
    }
}
