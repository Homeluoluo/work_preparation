package test;

/**
 * @Classname LockTest
 * @Description TODO
 * @Date 2019/3/25 22:04
 * @Created by luojia
 */
public class LockTest implements Runnable{
    private int i =0;
    static Object print1 = new Object();//第一个资源，比如说是一台打印机
    static Object print2 = new Object();//第二个资源，比如说是另一台打印机

    public void run() {

        if(i==0){
            synchronized(print1){
                System.out.println("已经占用了第一台打印机，再获取到第二台打印机之后就可以执行任务了。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(print2){
                    System.out.println("获取到了第二台打印机之后顺利执行完任务。。。");
                }
            }
        }

        if(i==1){
            synchronized(print2){
                System.out.println("已经占用了第二台打印机，再获取到第一台打印机之后就可以执行任务了。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(print1){
                    System.out.println("获取到了第一台打印机之后顺利执行完任务。。。");
                }
            }
        }

    }

    /**
     * <p>方法名称: main|描述: </p>
     * @param args
     */
    public static void main(String[] args) {
        LockTest t1 = new LockTest();
        LockTest t2 = new LockTest();
        t1.i = 0;
        t2.i = 1;
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}