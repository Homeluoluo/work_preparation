package crazy.codes.test.thread;

/**
 * @Classname ThreadTest08
 * @Description 线程让位  Thread.yield
 * @Date 2019/4/18 18:14
 * @Created by luojia
 */
public class ThreadTest08 {
    public static void main(String[] args) {
        MyRunnable08 runnable08=new MyRunnable08();
        Thread thread=new Thread(runnable08);
        thread.start();
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }

}
class MyRunnable08 implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
            if (i%20==0){
                Thread.yield();
            }
        }
    }
}
