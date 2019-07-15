package crazy.codes.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/5/5 17:46
 * @Created by luojia
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService es=Executors.newFixedThreadPool(2);
        ExecutorService es2=Executors.newSingleThreadScheduledExecutor();

    }
}
