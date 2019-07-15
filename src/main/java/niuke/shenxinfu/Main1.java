package niuke.shenxinfu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main1
 * @Description TODO
 * @Date 2019/5/25 8:52
 * @Created by luojia
 */
public class Main1 {
//    111359171715139131371191111
//    12361181091010123
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=Integer.parseInt(sc.nextLine());
        for (int i = 0; i <m ; i++) {
            String[] num_strs=sc.nextLine().split(" ");
            int a1=Integer.parseInt(num_strs[0]);
            int a2=Integer.parseInt(num_strs[1]);
            int a3=Integer.parseInt(num_strs[2]);
            long n=Integer.parseInt(num_strs[3]);
            System.out.println(getIntAt2(a1,a2,a3,n));
        }
    }

    public static int getIntAt(int a1,int a2,int a3,int index){
        List<Integer> numList=new ArrayList<>();
        numList.add(a1);
        numList.add(a2);
        numList.add(a3);
        while (numList.size()<index){
            int sizeNow=numList.size();
            int add=numList.get(sizeNow-1)+numList.get(sizeNow-2)+numList.get(sizeNow-3);
            while (add/10!=0){
                numList.add(add/10);
                add=add%10;
            }
            numList.add(add%10);
        }
        return numList.get(index-1);
    }
    public static int getIntAt2(int a1,int a2,int a3,long index){
        if(index==1)
            return a1;
        if(index==2)
            return a2;
        if(index==3)
            return a3;
        int i=3;
        while (i<index){
            int add=a1+a2+a3;
            if(add<10){
                a1=a2;
                a2=a3;
                a3=add;
                i=i+1;
            }else{
                a1=a3;
                a2=add/10;
                a3=add%10;
                i=i+2;
            }
        }
        if(i==index){
            return a3;
        }else{
            return a2;
        }
    }
    public static int getIntAt(int a1,int a2,int a3,long index){
        StringBuffer str=new StringBuffer();
        str.append(a1);
        str.append(a2);
        str.append(a3);
        int i=3;
        while (i<index){
            int add=a1+a2+a3;
            if(add<10){
                a1=a2;
                a2=a3;
                a3=add;
                i=i+1;
            }else{
                a1=a3;
                a2=add/10;
                a3=add%10;
                i=i+2;
            }
//            如果出现重复，终止循环
            String temp=String.valueOf(a1)+String.valueOf(a2)+String.valueOf(a3);
            if(str.toString().contains(temp))
                break;
            str.toString();
        }
        return 1;
    }
}

