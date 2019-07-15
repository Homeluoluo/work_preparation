package niuke;

import java.util.Scanner;

/**
 * @Classname BigNumChengJi1
 * @Description TODO
 * @Date 2019/4/6 15:17
 * @Created by luojia
 */
public class BigNumChengJi1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums=sc.nextLine().split(" ");
        char[] a=nums[0].toCharArray();
        char[] b=nums[1].toCharArray();
        int m=a.length;
        int n=b.length;
        int[][] result=new int[n+1][n+m];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j <n+m ; j++) {
                result[i][j]=0;
            }
        }
//        从低位到高位按位相乘
        int toHigh=0;//表示进位
//        用b的每一位依次去乘a
        for (int i = n-1; i >=0; i--) {
            for (int j = m-1; j >=0 ; j--) {
                int num=Integer.parseInt(b[i]+"")*Integer.parseInt(a[j]+"")+toHigh;
                toHigh=num/10;
                num=num%10;
                result[n-1-i][m-1-j+n-1-i]=num;
            }
            if(toHigh>0){
                result[n-1-i][m+n-1-i]=toHigh;
                toHigh=0;
            }
        }
        //相乘的结果相加
        int i = 0;
        for (; i <m+n ; i++) {
            int num=toHigh;
            for (int j = 0; j < n; j++) {
                num+=result[j][i];
            }
            result[n][i]=(num%10);
            toHigh=(num/10);
        }
        if(toHigh>0){
            result[n][i+1]=toHigh;
        }
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for (int j = result[n].length-1; j >=0 ; j--) {
            if(flag||result[n][j]!=0){
                flag=true;
                sb.append(result[n][j]);
            }
        }
        System.out.println(sb.toString());
    }

}
