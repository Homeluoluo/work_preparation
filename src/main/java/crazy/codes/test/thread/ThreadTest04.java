package crazy.codes.test.thread;

/**
 * @Classname ThreadTest04
 * @Description 线程的优先级：默认5，最高10，最低1
 * @Date 2019/4/18 15:46
 * @Created by luojia
 */
public class ThreadTest04 {
    public static void main(String[] args) {

        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);

        MyRunnable04 runnable04=new MyRunnable04();

        Thread thread1=new Thread(runnable04);
//        设置优先级
        thread1.setPriority(6);

        Thread thread2=new Thread(runnable04);
        thread2.setPriority(9);
        thread1.start();
        thread2.start();
//thread2优先级高，先执行
    }
}
class MyRunnable04 implements Runnable{
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}