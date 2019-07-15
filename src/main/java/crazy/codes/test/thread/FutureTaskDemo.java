package crazy.codes.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname FutureTaskDemo
 * @Description TODO
 * @Date 2019/5/7 20:56
 * @Created by luojia
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task is not finished,please wait");
        }
//        get方法获取返回值
        System.out.println(task.get());
     }
}
