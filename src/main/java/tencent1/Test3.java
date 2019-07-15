package tencent1;

import java.util.Scanner;

/**
 * @Classname Test3
 * @Description TODO
 * @Date 2019/4/4 18:06
 * @Created by luojia
 */
/*
2018春招技术类编程题汇总 第4题
* */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int K=Integer.valueOf(sc.nextLine());
        String[] nums=sc.nextLine().split(" ");
        if(nums.length!=4){
            System.out.println("输入不符合要求！");
        }
        int A=Integer.valueOf(nums[0]);
        int X=Integer.valueOf(nums[1]);
        int B=Integer.valueOf(nums[2]);
        int Y=Integer.valueOf(nums[3]);
        //解方程 aA+bB=K,a的范围是[0,X]，b的范围是[0,Y]
//        int max=MyMath.max(X,Y);
//        int small=MyMath.max(X,Y);
        int b=0;
        long result=0;
        for (int i = 0; i*A<=K && i <=X; i++) {
            if((K-i*A)%B==0){
                b=(K-i*A)/B;
                result += getNumOfCombination(b,Y)*getNumOfCombination(i,X);
//                result += getNumOfCombination(i,X);
            }
        }
        System.out.println(result%1000000007);
    }

    public static long getNumOfCombination(int b,int Y){
        if(2*b>Y){
            b=Y-b;
        }
        long result = 1;
        for (int i = Y; i >Y-b; i--) {
            result = result*i;
        }
        for (int j = 1; j <=b; j++) {
            result = result/j;
        }
        return result;
    }
}
