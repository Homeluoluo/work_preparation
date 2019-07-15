package test;

/**
 * @Classname ASCIITest
 * @Description TODO
 * @Date 2019/4/7 11:18
 * @Created by luojia
 */
public class ASCIITest {
    public static void main(String[] args) {
        char a='a';
        char A='A';
        int a_ascii=Integer.valueOf(a);
        int A_ascii=Integer.valueOf(A);
        System.out.println("字符"+a+"的ASCII码为："+a_ascii);
        System.out.println("字符"+A+"的ASCII码为："+A_ascii);
        System.out.println(A-2);
        System.out.println(A_ascii-a_ascii);
    }
}
