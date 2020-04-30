package niuke.wangyi2;

import java.util.Scanner;

/**
 * @Classname Main4
 * @Description 逆序对距离之和
 * @Date 2019/9/21 16:03
 * @Created by luojia
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        int[] nums=new int[num];
        for (int i = 0; i < num ; i++) {
            nums[i]=in.nextInt();
        }
        System.out.println(getSumOfAllReversePair(nums));
    }

    public static int getSumOfAllReversePair(int[] nums){
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<nums[i]){
                    sum=sum+(j-i);
                }
            }
        }
        return sum;
    }
}
