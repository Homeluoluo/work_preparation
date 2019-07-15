package tencent1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2019/4/4 14:17
 * @Created by luojia
 */
/*
2018春招技术类编程题汇总 第2题
* */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0;
        int[] nums;
        n=Integer.valueOf(sc.nextLine());
        nums=new int[n];
        String[] inputs=sc.nextLine().split(" ");
        if (inputs.length!=n){
            System.out.println("输入不符合规范");
            return;
        }
        for (int i = 0; i < inputs.length; i++) {
            nums[i]=Integer.valueOf(inputs[i]);
        }
        Arrays.sort(nums);
        int result=0;
        boolean flag=true;
        for (int i = n-1; i >=0; i--) {
            if(flag){
                result = result + nums[i];
            }else{
                result = result - nums[i];
            }
            flag=!flag;
        }
        System.out.println(result);
    }
}
