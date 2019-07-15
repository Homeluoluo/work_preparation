package crazy.codes.test.thread;

/**
 * @Classname ThreadTest03
 * @Description 关于线程名称，获取当前线程
 * @Date 2019/4/18 15:38
 * @Created by luojia
 */
public class ThreadTest03 {
    public static void main(String[] args) {
//                获取当前线程对象
        Thread t=Thread.currentThread();
        System.out.println(t.getName());
        MyRunnable01 myRunnable=new MyRunnable01();
        Thread thread1=new Thread(myRunnable);
        //        设置线程名
        thread1.setName("thread1");
        thread1.start();

        Thread thread2=new Thread(myRunnable);
        thread2.setName("thread2");
        thread2.start();

    }
}
class MyRunnable01 implements Runnable{
    public void run(){
        //                获取当前线程对象
        Thread t=Thread.currentThread();
//        获取线程名
        System.out.println(t.getName());
    }
}