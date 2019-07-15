package crazy.codes.test.thread.multithreading;

/**
 * @Classname LockTest
 * @Description 死锁产生
 * @Date 2019/4/18 21:25
 * @Created by luojia
 */
public class LockTest {
    public static void main(String[] args) {
        Object obj1=new Object();
        Object obj2=new Object();
        Thread t1=new Thread(new MyProcessor1(obj1,obj2));
        Thread t2=new Thread(new MyProcessor2(obj1,obj2));
        t1.start();
        t2.start();
    }
}
class MyProcessor1 implements Runnable{
    Object object1;
    Object object2;
    MyProcessor1(Object object1,Object object2){
        this.object1=object1;
        this.object2=object2;
    }
    public void run(){
        synchronized (object1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2){

            }
        }
    }

}
class MyProcessor2 implements Runnable{
    Object object1;
    Object object2;
    MyProcessor2(Object object1,Object object2){
        this.object1=object1;
        this.object2=object2;
    }
    public void run(){
        synchronized (object2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1){

            }
        }
    }
}