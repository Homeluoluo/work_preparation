package niuke.tengxun;

import java.util.Scanner;

/**
 * @Classname Main4
 * @Description TODO
 * @Date 2019/9/20 20:56
 * @Created by luojia
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] strings=in.nextLine().split(" ");
        int n=Integer.parseInt(strings[0]);
        int k=Integer.parseInt(strings[1]);
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        //循环打印k轮
        for (int i = 0; i < k; i++) {
            //寻找最小的非0元素
            int min=100000000;
            for (int j = 0; j <n ; j++) {
                if(nums[j]>0&&nums[j]<min){
                    min=nums[j];
                }
            }
            //输出最小的非零元素
            if(min!=100000000){
                System.out.println(min);
            }else{
                System.out.println(0);
                break;
            }
            //将序列中所有非零元素减min
            for (int j = 0; j <n ; j++) {
                if(nums[j]>0){
                    nums[j]=nums[j]-min>0?nums[j]-min:0;
                }
            }
        }
    }
}
