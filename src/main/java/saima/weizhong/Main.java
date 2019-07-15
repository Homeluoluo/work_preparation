package saima.weizhong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/11 17:54
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        /*String[] nums=sc.nextLine().split(" ");
        int n=Integer.parseInt(nums[0]);
        int m=Integer.parseInt(nums[1]);*/
        int m,n;
        n=sc.nextInt();
        m=sc.nextInt();
        boolean[] peoples=new boolean[n];
        for (int i = 0; i < n; i++) {
            peoples[i]=true;
        }
        int p=0;//记录报的数
        int exist=n;//记录还在游戏中的人数
        StringBuilder result = new StringBuilder("");
        if (exist==1){
            System.out.println();
            System.out.println(1);
        }
        while(exist>1){
            for (int i = 0; i < n ; i++) {
                if (peoples[i]){//这个人还在游戏中
                    p++;
                    if(p==m){//报到m的人退出游戏
                        peoples[i]=false;
                        result.append(i+1+" ");
                        exist--;
                        if(exist<=1){
                            break;
                        }
                        p=0;
                    }
                }
            }
        }
        System.out.println(result.toString());
        for (int i = 0; i < n; i++) {
            if (peoples[i]){
                System.out.println(i+1);
            }
        }
    }
    
}
