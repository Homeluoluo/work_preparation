package crazy.codes.test.thread;

/**
 * @Classname ThreadTest1
 * @Description 创建线程——继承thread类
 * @Date 2019/4/18 14:38
 * @Created by luojia
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("main-"+i);
        }
        Thread thread=new MyThread();
        thread.start();
//        thread.run();
        for (int i = 10; i < 20; i++) {
            System.out.println("main-"+i);
        }
    }
}
class MyThread extends Thread{
    public void run(){
        for (int i = 0; i <200 ; i++) {
            System.out.println("mythread-"+i);
        }
    }
}
