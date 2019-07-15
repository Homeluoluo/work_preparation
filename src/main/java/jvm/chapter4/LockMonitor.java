package jvm.chapter4;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname LockMonitor
 * @Description TODO
 * @Date 2019/4/23 0:39
 * @Created by luojia
 */
public class LockMonitor {
    /**
     * 线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable {
        int a, b;
        public SynAddRunalbe(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
        Set<String> s=new HashSet<>();
    }
}
