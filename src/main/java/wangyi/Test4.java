package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Test4
 * @Description TODO
 * @Date 2019/4/2 19:43
 * @Created by luojia
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] strs=str.split(" ");
        List<Integer> nums=new ArrayList<>();
        int result=0;
        for (int i = 0; i < strs.length; i++) {
            nums.add(Integer.valueOf(strs[i]));
        }
    }
}
