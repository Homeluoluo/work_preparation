package design.pattern.singleton;

//饿汉模式：没有lazy loading（懒加载，又叫按需加载）的效果，从而降低内存的使用率
public class Singleton3 {
    private Singleton3(){}
    private static Singleton3 instance=new Singleton3();
    public static Singleton3 getInstance(){
        return instance;
    }
}
