package design.pattern.singleton;

public class Singleton2 {
    //构造函数私有化
    private Singleton2(){}
    //static关键字：强调属性只有一个
    private static Singleton2 instance=null;

    // 懒汉模式
    // synchronized关键字 添加同步锁，多线程可用，但是效率很低
    public static synchronized Singleton2 getInstance(){
        if(instance==null){
            instance=new Singleton2();
        }
        return instance;
    }

    //双重校验模式
    public static Singleton2 getInstance2(){
        if(instance==null){
            //只有实例为空时才加同步锁，因为加锁很费时
            synchronized (Singleton2.class){
                //为什么加锁之后还要判断？
                if(instance==null){
                    instance=new Singleton2();
                }
            }
        }
        return instance;
    }
}
