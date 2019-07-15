package design.pattern.singleton;

//单例模式最佳实现：用静态内部类实现了按需加载
public class Singleton4 {
    private Singleton4(){}
    private static class SingletonHolder{
        private final static Singleton4 instance=new Singleton4();
    }

    public static Singleton4 getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String args[]){
        Singleton4 obj=Singleton4.getInstance();
        System.out.println(obj);
        Singleton4 obj2=Singleton4.getInstance();
        System.out.println(obj2);
    }
}
