package crazy.codes.test.thread;

import java.util.concurrent.Callable;

/**
 * @Classname MyCallable
 * @Description TODO
 * @Date 2019/5/7 20:53
 * @Created by luojia
 */
//String表示call方法的返回值
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value="test";
        System.out.println("ready to work");
        Thread.currentThread().sleep(5000);
        System.out.println("work is done");
        return value;
    }
}
