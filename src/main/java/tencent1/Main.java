package tencent1;

import java.util.*;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/5 16:54
 * @Created by luojia
 * 小Q今天在上厕所时想到了这个问题：有n个数，两两组成二元组，相差最小的有多少对呢？相差最大呢？
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        int small=nums[n-1]-nums[0];
        int smallPairNum=0;
        int bigPairNum=1;
        for (int i = 0; i < n-1; i++) {
            int sub=nums[i+1]-nums[i];
            if(sub<small){
                smallPairNum=1;
                small=sub;
            }else if(sub==small){
                smallPairNum++;
            }
        }
        int smallNum=1;
        for (int i = n-2; nums[i]==nums[n-1]; i--) {
            bigPairNum++;
        }
        for (int i = 1 ; nums[i]==nums[0]; i++) {
            smallNum++;
        }
        System.out.println(smallPairNum+" "+bigPairNum*smallNum);
    }

    //反转字符串
    public static void reverseString(String str,int fromIndex,int endIndex){
        for (int i = fromIndex; i < (fromIndex+endIndex)/2 ; i++) {
            str.charAt(fromIndex);
        }
    }
}
