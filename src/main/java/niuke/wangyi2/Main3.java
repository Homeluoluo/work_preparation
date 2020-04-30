package niuke.wangyi2;

import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/9/21 15:51
 * @Created by luojia
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int groupNum=Integer.parseInt(in.nextLine());
        for (int i = 0; i <groupNum ; i++) {
            int length=Integer.parseInt(in.nextLine());
            String[] strings=in.nextLine().split(" ");
            int[] nums=new int[length];
            for (int j = 0; j < length; j++) {
                nums[j]=Integer.parseInt(strings[j]);
            }
            System.out.println(getLongestLength(nums));
        }
    }
    public static int getLongestLength(int[] nums){
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=nums[i];
            int length=1;
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[j]>=sum){
                    sum+=nums[j];
                    length++;
                }else{
                    if(length>result){
                        result=length;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
