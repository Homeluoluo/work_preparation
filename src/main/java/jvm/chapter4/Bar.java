package jvm.chapter4;

/**
 * @Classname Bar
 * @Description TODO
 * @Date 2019/4/23 0:10
 * @Created by luojia
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}