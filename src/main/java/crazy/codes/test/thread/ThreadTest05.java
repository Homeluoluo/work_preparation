package crazy.codes.test.thread;

/**
 * @Classname ThreadTest05
 * @Description 线程阻塞sleep()
 * @Date 2019/4/18 16:02
 * @Created by luojia
 */
public class ThreadTest05 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable05 runnable05=new MyRunnable05();
        Thread thread=new Thread(runnable05);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            Thread.sleep(500);
        }
    }
}

class MyRunnable05 implements Runnable{
//    Runnable的run方法不抛出异常，所以在重写的run方法声明的地方不能使用throws，只能使用try catch
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
