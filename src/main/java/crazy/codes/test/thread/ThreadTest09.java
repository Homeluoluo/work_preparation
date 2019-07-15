package crazy.codes.test.thread;

/**
 * @Classname ThreadTest09
 * @Description 线程合并join
 * @Date 2019/4/18 18:27
 * @Created by luojia
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        MyRunnable09 runnable09=new MyRunnable09();
        Thread thread=new Thread(runnable09);
        thread.start();
        /*try {
            thread.join();//hread和语句所在线程合并
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }

    }
}
class MyRunnable09 implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+": "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
