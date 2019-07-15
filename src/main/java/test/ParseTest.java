package test;

/**
 * @Classname ParseTest
 * @Description TODO
 * @Date 2019/4/7 15:29
 * @Created by luojia
 */
public class ParseTest {
    public static void main(String[] args) {
        char a='3';
//        输出字符的ASCII码
        System.out.println(Integer.valueOf(a));

//        char转int 使用Integer.parseInt(String s)
        int a1=Integer.parseInt(a+"");
        System.out.println(a1);

//        int转char
//        1、如果int的范围为[0,9],使用数字和字符'0'做运算，得到数字字符的ASCII码，再使用强制类型转换，注意不能直接进行强制类型转换
        int b=6;
        char b1=(char)(b+'0');
        System.out.println(b1);
        char b2=(char)b;
//        6对应的是一个控制字符，所以输出一个空行
        System.out.println(b2);
//        2、如果int的范围不是[0,9]，比如40，则先转换为String，再转换为字符数组char[]
        int c=40;
        char[] cs=String.valueOf(c).toCharArray();
        for(char c1:cs){
            System.out.println(c1);
        }
    }
}
