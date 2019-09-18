package javabasic.jvm;

import javabasic.thread.ThreadTest;

import java.sql.SQLOutput;

/**
 * @Classname DeapLoadClass
 * @Description TODO
 * @Date 2019/9/16 16:35
 * @Created by luojia
 */
public class DeapLoadClass {
    public int a=2;
    static {
        if(true){
            System.out.println(Thread.currentThread()+"init DeapLoadClass");
//            System.out.println(a);
            while (true){

            }
        }
    }

    public static void main(String[] args) {
        Runnable script=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                DeapLoadClass deapLoadClass=new DeapLoadClass();
                System.out.println(deapLoadClass.a);
                System.out.println(Thread.currentThread()+"run over");
            }
        };

        Thread thread1=new Thread();
        Thread thread2=new Thread();
        thread1.start();
        thread2.start();
    }
}
