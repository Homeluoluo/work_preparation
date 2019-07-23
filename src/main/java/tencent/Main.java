package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/5 19:18
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=Integer.valueOf(sc.nextLine());
        int[] n=new int[T];
        String[] strings=new String[T];
        for (int i = 0; i < T; i++) {
            n[i]=Integer.valueOf(sc.nextLine());
            strings[i]=sc.nextLine();
        }
        for (int i = 0; i < T; i++) {
            String[] numStrs=strings[i].split(" ");
            int[] nums=new int[n[i]];
            for (int j = 0; j < n[i]; j++) {
                nums[j]=Integer.valueOf(numStrs[j]);
            }
            print(nums,n[i]);
        }
    }

    public static void print(int[] nums,int n){
        int[] waitBuild=new int[n];
        int m=0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==n-i){
                System.out.println(nums[i]);
            }else if(nums[i]>n-i){
                waitBuild[m]=nums[i];
                m++;
                Arrays.sort(waitBuild);
                StringBuilder sb=new StringBuilder();
                for (int j = n-1; waitBuild[j]>=n-i&&j >=0; j--) {
                    sb.append(waitBuild[j]);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }else{//提前送达
                waitBuild[m]=nums[i];
                m++;
                System.out.println(" ");
            }
        }
    }
}
