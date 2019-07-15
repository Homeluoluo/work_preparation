package test;

/**
 * @Classname TypeTransform
 * @Description TODO
 * @Date 2019/4/12 22:33
 * @Created by luojia
 */
public class TypeTransform {
    public static void main(String[] args) {
        double s=1.25;
        int a=(int)s;
        System.out.println(a);
        String ss = String.format("%1.2f", 1.1256);   //1.13
        System.out.println("转换4="+ss);
    }
}
