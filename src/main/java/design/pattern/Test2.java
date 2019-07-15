package design.pattern;

public class Test2 {
    private final static Object obj=new Object();
    public static void main(String args[])
    {
        Test2 test=new Test2();
        Test2 test1=new Test2();
        System.out.println(test);
        System.out.println(test.obj);
        System.out.println(test1);
        System.out.println(test1.obj);
    }
}
