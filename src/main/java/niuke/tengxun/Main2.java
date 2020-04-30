package niuke.tengxun;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/9/20 20:17
 * @Created by luojia
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        List<Integer> times=new ArrayList<>();
        //总人数 m为偶数
        int m=0;
        for (int i = 0; i < num; i++) {
            String[] strings=in.nextLine().split(" ");
            int a=Integer.parseInt(strings[0]);
            m+=a;
            for (int j = 0; j <a ; j++) {
                times.add(Integer.parseInt(strings[1]));
            }
        }
        Collections.sort(times);
        int sum=0;
        int temp=0;
        for (int i = 0; i < m/2; i++) {
            temp=times.get(i)+times.get(m-1-i);
            if(temp>sum){
                sum=temp;
            }
        }
        System.out.println(sum);
    }
}
