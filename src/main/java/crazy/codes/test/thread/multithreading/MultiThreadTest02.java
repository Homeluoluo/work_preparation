package crazy.codes.test.thread.multithreading;

/**
 * @Classname MultiThreadTest02
 * @Description TODO
 * @Date 2019/4/18 20:56
 * @Created by luojia
 */
public class MultiThreadTest02 {
    public static void main(String[] args) {
        Myclass m=new Myclass();
        Processor p=new Processor(m);
        Thread thread=new Thread(p);
        thread.setName("m1");
        Thread thread2=new Thread(p);
        thread2.setName("m2");
        thread.start();
        thread2.start();
    }
}
class Processor implements Runnable{
    private Myclass m;
    public Processor(Myclass m){
        this.m=m;
    }
    public void run() {
        if(Thread.currentThread().getName().equals("m1")){
            m.m1();
        }
        if (Thread.currentThread().getName().equals("m2")){
            m.m2();
        }
    }
}
class Myclass{
    public synchronized static void m1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1......");
    }
    public static void m2(){

        System.out.println("m2......");
    }

}