package LiKoHot100.图论;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ThreadMain {

    public static void main(String[] args){


        //定义固定线程池数：
        ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                // 创建新的线程：
                Thread thread = new Thread(r);
                // 设置是否为守护线程
                thread.setDaemon(false);
                // 设置线程名
                thread.setName("thread1");
                return thread;
            }
        });

        for (int i = 0; i < 10; i++) {

            Future<?> submit = executorService.submit(() -> {
                String name = Thread.currentThread().getName();
                System.out.println("当前线程名：" + name);
            });
            System.out.println("提交返回值：" + submit);
        }
        executorService.shutdown();
    }
}
