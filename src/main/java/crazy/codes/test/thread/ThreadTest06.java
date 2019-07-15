package crazy.codes.test.thread;

/**
 * @Classname ThreadTest05
 * @Description 线程阻塞sleep()，唤醒sleep的线程
 * @Date 2019/4/18 16:02
 * @Created by luojia
 */
public class ThreadTest06 {
    public static void main(String[] args) throws InterruptedException {
//        需求，启动线程，5s之后唤醒
        MyRunnable06 runnable06=new MyRunnable06();
        Thread thread=new Thread(runnable06);
        thread.start();
//        计时5s
        Thread.sleep(5000);
//        中断线程的休眠，依靠异常处理机制
        thread.interrupt();
    }
}

class MyRunnable06 implements Runnable{
    //    Runnable的run方法不抛出异常，所以在重写的run方法声明的地方不能使用throws，只能使用try catch
    public void run(){
        try {
            Thread.sleep(1000000000);
            System.out.println("我自己醒了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
