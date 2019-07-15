package niuke.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/14 9:48
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=0,n=0;//记录矩阵的行数和列数
        List<String> inputs=new ArrayList<>();
        while (sc.hasNextLine()){
            String a=sc.nextLine();
            inputs.add(a);
            if(a.equals("")){
                break;
            }else{
                m++;
            }
        }
        n=inputs.get(0).split(" ").length;
//        矩阵初始化
        int[][] originMatrix=new int[m][];
        for (int i = 0; i < m ; i++) {
            originMatrix[i]=new int[n];
            String[] nums=inputs.get(i).split(" ");
            for (int j = 0; j < n; j++) {
                originMatrix[i][j]=Integer.parseInt(nums[j]);
            }
        }
        System.out.println(calTime(originMatrix,m,n));
//        calTime(originMatrix,m,n);
    }

    public static int calTime(int[][] a,int m,int n){
//        记录遍历的次数
        int count=0;
//        记录一次遍历是否有产品经理变为程序员
        boolean flag=false;
        while (true){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                该节点为程序员节点
                    if(a[i][j]==2){
//                    前面一个元素存在（主要是判断越界）
                        if(j-1>=0){
//                        将向前的产品经理变成程序员
                            if(a[i][j-1]==1){
                                a[i][j-1]=2;
                                flag=true;
                            }
                        }
//                   上面一个元素存在（主要是判断越界）
                        if(i-1>=0){
//                        将向上的产品经理变成程序员
                            if(a[i-1][j]==1){
                                a[i-1][j]=2;
                                flag=true;
                            }
                        }
//                  后面一个元素存在（主要是判断越界）
                        if(j+1<n){
//                      将后面的产品经理做变成程序员的标记
                            if(a[i][j+1]==1){
                                a[i][j+1]=4;
                                flag=true;
                            }
                        }
//                  下面一个元素存在（主要是判断越界）
                        if(i+1<m){
//                      将下面的产品经理做变成程序员的标记
                            if(a[i+1][j]==1){
                                a[i+1][j]=4;
                                flag=true;
                            }
                        }
                    }
                    if(a[i][j]==4){
                        a[i][j]=2;
                        flag=true;
                    }
                }
            }
            if (!flag){
                break;
            }else{
                count++;
                flag=false;
            }
//
            for (int i = 0; i < m ; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i][j]==1){
                    count=-1;
                }
            }
        }
        return  count;
    }
}
