package niuke.shenxinfu;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/9/18 16:42
 * @Created by luojia
 */
public class Test{
    public static void main(String args[]){
        sout(5);
    }
    //nums表示最长边的边长
    public static void sout(int nums){
        for(int i=nums;i>0;i--){
            String a="";
            for(int j=i;j>0;j--){
                a+="*";
            }
            System.out.println(a);
        }
    }
}
