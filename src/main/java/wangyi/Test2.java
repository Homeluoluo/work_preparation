package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2019/4/2 20:43
 * @Created by luojia
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String str=sc.nextLine();
        int[] nums=new int[n];
        String[] strings=str.split(" ");
        for (int i = 0; i < strings.length ; i++) {
            nums[i]=Integer.valueOf(strings[i]);
        }
        if(n<3){
            System.out.println(0);
            return;
        }
        Arrays.sort(nums);
        int result=0;
        for(int i=0;i<=n-3;i++){
            for (int j = i+1; j <= n-2; j++) {
                //两个数的最大公约数为1
                if(getMaxCommon(nums[i],nums[j])){
                    System.out.println(n-j-1);
                    result += n-j-1;
                    System.out.println(result);
                }
            }
        }
        System.out.println(result);

    }
    //判断两个数的最大公约数是否为1
    public static boolean getMaxCommon(int a,int b){
        if(a==1){
            return true;
        }else{
            if(b%a==0){
                return false;
            }else{
                for(int i=2;i<a;i++){
                    if(a%i==0 && b%i==0){
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
