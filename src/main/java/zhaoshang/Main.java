package zhaoshang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入
        Scanner input = new Scanner(System.in);
        int N =Integer.parseInt(input.nextLine());
        int[][] coinArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                coinArray[i][j]=0;
            }
        }
        coinArray[0][0]= Integer.parseInt(input.nextLine());
        for (int i = 1; i < N; i++) {
            String[] nums = input.nextLine().split(" ");
            for (int j = 0; j < nums.length; j++) {
                coinArray[i][j]=Integer.parseInt(nums[j]);
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <i+1 ; j++) {
                if (j==0){
                    //每行第一个
                    coinArray[i][j] += coinArray[i-1][j];
                }else if (j==i){
                    //每行最后一个
                    coinArray[i][j] += coinArray[i-1][j-1];
                }else{
                    Integer left = coinArray[i][j]+coinArray[i-1][j-1];
                    Integer right = coinArray[i][j]+coinArray[i-1][j];
                    coinArray[i][j] = left>right?left:right;
                }
            }
        }
        int[] resultArray = coinArray[N-1];
        System.out.println(Arrays.stream(resultArray).max().getAsInt());
    }
}
