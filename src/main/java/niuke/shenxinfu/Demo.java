package niuke.shenxinfu;

/**
 * @Classname Demo
 * @Description TODO
 * @Date 2019/9/18 16:53
 * @Created by luojia
 */
public class Demo {
    public int add(int a,int b){
        try{
            return a+b;
        }catch (Exception e){
            System.out.println("catch 语句块执行");
        }finally {
            System.out.println("finally 语句块执行");
        }
        return 0;
    }

    public static void main(String[] args) {
        Demo demo=new Demo();
        System.out.println("和为："+demo.add(9,34));
    }
}
