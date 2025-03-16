package LiKoHot100.矩阵;

import java.util.ArrayList;
import java.util.List;



public class Test implements Runnable {
    List<String> list = new ArrayList<String>();
    public void run(){
        try {
            Thread.sleep((int)(Math.random()*2));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ThreadGroup group = new ThreadGroup("test");
        Test at = new Test();
        for (int i = 0; i < 10000; i++) {
            Thread th = new Thread(group, at);
            th.start();
        }
        while(group.activeCount() > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("length: " + at.list.size());
    }
}
