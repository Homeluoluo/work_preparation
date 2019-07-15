package crazy.codes.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Classname ThreadPoolDemo
 * @Description TODO
 * @Date 2019/5/7 21:02
 * @Created by luojia
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Future<String> future = newCachedThreadPool.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("task is not finished,please wait");
        }
//        get方法获取返回值

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
//            用完线程池一定要关闭
            newCachedThreadPool.shutdown();
        }
    }
}
