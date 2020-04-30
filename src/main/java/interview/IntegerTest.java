package interview;

/**
 * @Classname IntegerTest
 * @Description TODO
 * @Date 2019/9/26 10:28
 * @Created by luojia
 */
public class IntegerTest {

    //玄武笔试
    public static void testEquals(){
        Integer a=127;
        Integer b=new Integer(127);
        Integer c=Integer.valueOf(127);
        System.out.println("a==b?"+(a==b));
        System.out.println("a==c?"+(a==c));
        System.out.println("b==c?"+(b==c));
    }

    public static void main(String[] args) {
        testEquals();
    }
}
