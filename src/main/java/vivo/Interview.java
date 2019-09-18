package vivo;

/**
 * @Classname Interview
 * @Description vivo 面试
 * @Date 2019/9/17 22:40
 * @Created by luojia
 */
public class Interview {
    public static void main(String[] args) {
        System.out.println(test1());
    }

    public static boolean test1(){
        float a=1.0f-0.9f;
        float b=0.7f-0.6f;
        System.out.println("a="+a);
        System.out.println("b="+b);
        if (a==b){
            return true;
        }else{
            return false;
        }
    }
}
