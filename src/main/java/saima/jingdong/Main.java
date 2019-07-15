package saima.jingdong;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/13 18:52
 * @Created by luojia
 */
public class Main {
//    求树的子树节点数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        Set<Integer> left=new HashSet<>();
        Set<Integer> right=new HashSet<>();
        for (int i = 2; i <= n; i++) {
            String[] nums=sc.nextLine().split(" ");
            if(Integer.parseInt(nums[1])==1){
                if (left.size()==0){
                    left.add(Integer.parseInt(nums[0]));
                }else{
                    right.add(Integer.parseInt(nums[0]));
                }
            }else{
                if(left.contains(Integer.parseInt(nums[1]))){
                    left.add(Integer.parseInt(nums[0]));
                }
                if(right.contains(Integer.parseInt(nums[1]))){
                    right.add(Integer.parseInt(nums[0]));
                }
            }
        }
        System.out.println(left.size()>right.size()?left.size():right.size());
    }
}
