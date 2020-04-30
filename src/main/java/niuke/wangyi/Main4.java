package niuke.wangyi;

import java.util.Scanner;

/**
 * @Classname Main4
 * @Description TODO
 * @Date 2019/9/20 18:46
 * @Created by luojia
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs=in.nextLine().split(" ");
        //获取输入的行数和长度
        int N=Integer.parseInt(strs[0]);
        int M=Integer.parseInt(strs[1]);
        char[][] input=new char[N][M];
        //根据输入初始化矩阵
        for (int i = 0; i < N; i++) {
            char[] line=in.nextLine().toCharArray();
            input[i] = line;
        }
        getMaxSameCharMatrix(input);
    }
    public static void getMaxSameCharMatrix(char[][] input){
        int max=0;
        int startX=1;
        int startY=1;
        int len=0;
        int n=input.length;
        int m=input[0].length;
        //保证n<m
        if(n>m){
            int temp=m;
            m=n;
            n=temp;
        }
        //从最大的边长开始寻找
        for (int s = n; s >0; s--) {
            int num=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    char curent=input[j][k];
                    for (int i = 0; i <n ; i++) {
                        for (int l = 0; l < n; l++) {
                            if(j+s<n&&k+s<m){
                                if(input[j+s][k+s]==curent){
                                    num++;
                                }
                            }else{

                                break;
                            }
                        }
                    }
                    if (num>2){

                    }
                }
            }
        }
    }
}
