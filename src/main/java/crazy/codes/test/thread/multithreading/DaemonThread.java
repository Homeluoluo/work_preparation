package crazy.codes.test.thread.multithreading;

/**
 * @Classname DaemonThread
 * @Description TODO
 * @Date 2019/4/18 21:45
 * @Created by luojia
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new Processor2());
//        将thread设为守护线程
        thread.setDaemon(true);
        thread.start();

//        主线程
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}

class Processor2 implements Runnable{
    public void run(){
        int i=0;
        while (true){
            System.out.println(Thread.currentThread().getName()+": "+i);
            i++;
        }
    }
}