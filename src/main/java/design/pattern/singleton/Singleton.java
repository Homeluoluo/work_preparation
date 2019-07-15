package design.pattern.singleton;
//参考博客 https://www.cnblogs.com/hupp/p/4487521.html
//单例模式
public class Singleton {
    //构造函数私有化
    private Singleton(){}
    //static关键字：强调属性只有一个
    private static Singleton obj=null;
    //单线程可用，多线程时会出问题（两个线程同时调用getInstance方法，会产生两个实例）
    public static Singleton getInstance(){
        if(obj==null){
            obj=new Singleton();
        }
        return obj;
    }

    public static void main(String args[]){
        Singleton obj=Singleton.getInstance();
        System.out.println(obj);
        Singleton obj2=Singleton.getInstance();
        System.out.println(obj2);
    }
}
