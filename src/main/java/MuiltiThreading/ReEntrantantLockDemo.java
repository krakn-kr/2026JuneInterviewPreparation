package MuiltiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantantLockDemo {

    public static void main(String[] args) {
        ReentrantLock1 sharedTask = new ReentrantLock1();
        Thread thread = new Thread(sharedTask);
        Thread thread2 = new Thread(sharedTask);
        Thread thread3 = new Thread(sharedTask);
        thread.start();
        thread2.start();
        thread3.start();
    }
}
class ReentrantLock1 implements Runnable{

    ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        reentrantLock.lock();
        System.out.println("started thread"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("completed thread "+Thread.currentThread().getName());
        reentrantLock.unlock();
    }
}
