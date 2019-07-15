package crazy.codes.test.thread;

/**
 * @Classname ThreadTest05
 * @Description 线程终止
 * @Date 2019/4/18 16:02
 * @Created by luojia
 */
public class ThreadTest07 {
    public static void main(String[] args) throws InterruptedException {
//        需求，启动线程，5s之后终止线程
        MyRunnable07 runnable07=new MyRunnable07();
        Thread thread=new Thread(runnable07);
        thread.start();
//        计时5s
        Thread.sleep(5000);
//        5秒时候终止
        runnable07.run=false;
    }
}

class MyRunnable07 implements Runnable{
    boolean run=true;
    public void run(){
        for (int i = 0; i < 10; i++) {
            if(run){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }else{
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
