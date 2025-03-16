package LiKoHot100.矩阵;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallerTask implements Callable {
    @Override
    public String call() throws Exception {
        return "hello Callable";
    }

    public static void main(String[] args) {

        // 使用futureTask进行接收
        FutureTask<String> task = new FutureTask<String>(new CallerTask());
        new Thread(task).start();
        try {
            String res = task.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
