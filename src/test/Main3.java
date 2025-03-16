package test;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Object lock= new Object();
        Thread thread1 = new Thread(new OddPrinter(atomicInteger, lock));
        Thread thread2 = new Thread(new EventPrinter(atomicInteger, lock));

        thread1.start();
        thread2.start();
    }
}

/**
 * 奇数：
 */
class OddPrinter implements Runnable{

    // 原子类
    private final AtomicInteger number;
    private final Object lock;

    OddPrinter(AtomicInteger number, Object lock) {
        this.number = number;
        this.lock = lock;
    }
    @Override
    public void run() {
        while (number.get()<=100){
            // 加锁判断
            synchronized (this.lock){
                if (number.get() % 2 == 1){
                    // 获取数据
                    System.out.println("线程1：" + number.getAndIncrement());
                    // 唤醒锁
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

/**
 * 偶数
 */
class EventPrinter implements Runnable{

    private final AtomicInteger number;
    private final Object lock;

    EventPrinter(AtomicInteger number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (number.get()<=100){
            // 加锁判断
            synchronized (this.lock){
                if (number.get() % 2 == 0){
                    System.out.println("线程2：" + number.getAndIncrement());
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}