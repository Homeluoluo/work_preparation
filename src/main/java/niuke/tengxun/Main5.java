package niuke.tengxun;

import java.util.Scanner;

/**
 * @Classname Main5
 * @Description TODO
 * @Date 2019/9/20 21:13
 * @Created by luojia
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        int[] a=new int[num];
        int[] b=new int[num];
        String[] as=in.nextLine().split(" ");
        String[] bs=in.nextLine().split(" ");
        for (int i = 0; i < num; i++) {
            a[i]=Integer.parseInt(as[i]);
            b[i]=Integer.parseInt(bs[i]);
        }
        int result=0;
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j < num; j++) {
                int sum=a[i]+b[j];
                if(i==0&&j==0){
                    result+=sum;
                }else{
                    result=result^sum;
                }
            }
        }
        System.out.println(result);
    }
}
