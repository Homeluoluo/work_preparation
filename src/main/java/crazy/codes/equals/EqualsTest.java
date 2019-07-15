package crazy.codes.equals;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname EqualsTest
 * @Description TODO
 * @Date 2019/4/29 0:21
 * @Created by luojia
 */
public class EqualsTest {
    public static void main(String[] args) {
//        basicDataTypeTest();
        IntegerTest();
    }

//    基本数据类型比较
    public static void basicDataTypeTest(){
//   int比较
        int int_a=2;
        int int_b=2;
        System.out.println(int_a==int_b);//true
        int int_c=123456;
        int int_d=123456;
        System.out.println(int_c==int_d);//true

//    float比较
//        float float_a=1.2;

    }

    public static void IntegerTest(){
        Integer a=1;
        Integer b=1;
        Integer c=123456;
        Integer d=123456;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(a,null);
        map.put(c,null);
        System.out.println(a==b);//true
        System.out.println(c==d);//true
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
        System.out.println(map.containsKey(b));
        System.out.println(map.containsKey(d));
        int p='a';
        System.out.println(p);
    }
}
