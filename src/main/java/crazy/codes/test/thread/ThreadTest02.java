package crazy.codes.test.thread;

/**
 * @Classname ThreadTest02
 * @Description 创建线程——实现runnable接口
 * @Date 2019/4/18 15:05
 * @Created by luojia
 */
public class ThreadTest02 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("main-"+i);
        }
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(myRunnable);
        thread1.start();

        Thread thread2=new Thread(myRunnable);
        thread2.start();
//        thread.run();
        for (int i = 10; i < 2000; i++) {
            System.out.println("main-"+i);
        }
    }
}
class MyRunnable implements Runnable{
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("MyThread-"+i);
        }
    }
}
