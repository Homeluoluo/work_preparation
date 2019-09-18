package javabasic.jvm.model;

/**
 * @Classname TestStatistic
 * @Description TODO
 * @Date 2019/9/16 16:40
 * @Created by luojia
 */
public class TestStatistic {

    public static void main(String[] args) {
        sub sub1= new sub();
    }

    static class parent{
        public static int a = 100;
        public int b =10;

        public parent() {
            System.out.println(a);
            System.out.println(b);
        }
    }

    static class sub extends parent{

    }
}
