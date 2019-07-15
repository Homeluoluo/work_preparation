package tencent1;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class Test4 {
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
        BigDecimal result=new BigDecimal(0);
        for (int i = 0; i*A<=K && i <=X; i++) {
            if((K-i*A)%B==0){
                b=(K-i*A)/B;
                result.add(computeZuhe(Y,b).multiply(computeZuhe(X,i)).setScale(1, RoundingMode.HALF_UP));
            }
        }
        System.out.println(result.doubleValue()%1000000007);
    }

    public static BigDecimal computePaiLie(int n, int m) {
        if(m > n || n < 0 || m < 0) {
            throw new IllegalArgumentException("n必须大于m!");
        }
        return computerJC(n).divide(computerJC(n - m), 1, RoundingMode.HALF_UP);
    }

    public static BigDecimal computeZuhe(int n, int m) {
        if(m > n || n < 0 || m < 0) {
            throw new IllegalArgumentException("n必须大于m!");
        }
        //=n!/m!(n-m)!
        return computerJC(n).divide((computerJC(m).multiply(computerJC(n - m)).setScale(1, RoundingMode.HALF_UP)), 1, RoundingMode.HALF_UP);
    }


    public static BigDecimal computerJC(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("n不能为负数!");
        } else if(n == 0) {
            return new BigDecimal(1);
        }
        BigDecimal bd = new BigDecimal(1.0);
        for(int i=n; i>=1; i--) {
            bd = bd.multiply(new BigDecimal(i)).setScale(1, RoundingMode.HALF_UP);
        }
        return bd;
    }
}
