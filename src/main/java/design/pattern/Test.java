package design.pattern;

//非单例模式
public class Test {
    public Test(){

    }

    public static void main(String args[])
    {
        Test test=new Test();
        Test test1=new Test();
        System.out.println(test);
        System.out.println(test1);
    }
}
