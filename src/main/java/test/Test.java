package test;

import java.util.*;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/4/8 19:24
 * @Created by luojia
 */
public class Test {
//    a,b,c,d
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int num=Integer.parseInt(sc.nextLine());
        String[] chars=line.substring(1,line.length()-1).split(",");
        int length=chars.length;
        int[] nums=new int[length];
        for (int i = 0; i < length ; i++) {
            nums[i]=Integer.parseInt(chars[i]);
        }
        if(num>=length){
            nums=reverse(nums,0,length);
        }else{
            int begin=0;
            int end=0;
            while (end<length-1){
                if(end+num<length){
                    end=begin+num-1;
                }else{
                    end=length-1;
                }
                nums=reverse(nums,begin,end);
                begin+=num;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int[] reverse(int[] nums,int begin,int end){
        int temp=0;
        for(int i=begin;i<(begin+end)/2+1;i++){
            temp=nums[i];
            nums[i]=nums[end-(i-begin)];
            nums[end-(i-begin)]=temp;
        }
        return nums;
    }

    public static void test2(){
        Scanner sc=new Scanner(System.in);
        String[] chars=sc.nextLine().split(" ");
        Set<String> charSet=new HashSet<>();
        for (int i = 0; i < chars.length ; i++) {
            charSet.add(chars[i]+"");
        }
        System.out.println(charSet.size());
        System.out.println(chars.length);
        if(charSet.size()<chars.length){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }

    public void test(){
        Stack<Integer> s=new Stack<>();
    }
}
