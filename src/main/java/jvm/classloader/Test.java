package jvm.classloader;

import jvm.chapter4.Bar;

/**
 * @Author luojia
 * @Description TODO
 * @Date 2019/7/24
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello,World!");

        ClassLoader loader = Bar.class.getClassLoader();

        System.out.println(loader);
    }
}
