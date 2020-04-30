package niuke.wangyi;

import java.util.Scanner;

/**
 * @Classname Main
 * @Description 网易游戏校招笔试第一题
 * @Date 2019/9/20 16:58
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] nums=in.nextLine().split(" ");
        long num1=Long.parseLong(nums[0]);
        long num2=Long.parseLong(nums[1]);
        System.out.println(getMaxCommon(num1,num2));
        System.out.println(getMinCommon(num1,num2));
    }

    //求最大公约数
    public static long getMaxCommon(long a,long b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        //保证a>b
        if(a<b){
            long temp=b;
            b=a;
            a=temp;
        }
        long c=a%b;
        while(c!=0){
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }

    //求最小公倍数
    public static long getMinCommon(long a,long b){
        if(a==0||b==0){
            return 0;
        }
        //保证a>b
        if(a<b){
            long temp=b;
            b=a;
            a=temp;
        }
        long i=a;
        for(;i<a*b;i=i+a){
            if(i%b==0){
                break;
            }
        }
        return i;
    }
}
