package niuke.wangyi;

import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/9/20 18:15
 * @Created by luojia
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //预计购买的游戏币总数
        int N=Integer.parseInt(in.nextLine());
        //游戏币种类数
        int numOfClass=Integer.parseInt(in.nextLine());
        int[] nums=new int[numOfClass];
        float[] prices=new float[numOfClass];
        for (int i = 0; i < numOfClass; i++) {
            String[] strs=in.nextLine().split(",");
            nums[i]=Integer.parseInt(strs[0]);
            prices[i]=Float.parseFloat(strs[1]);
        }
        System.out.println(getMaxProfit(N,nums,prices));
    }

    //动态规划法求最优解
    public static float getMaxProfit(int N,int[] nums,float[] prices){
        float[][] profits=new float[nums.length+1][N+1];
        //初始化矩阵
        for (int i = 0; i < nums.length+1; i++) {
            profits[i][0]=0;
        }
        for (int i = 0; i <N+1 ; i++) {
            profits[0][i]=0;
        }
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(j<nums[i-1]){
                    profits[i][j]=profits[i-1][j];
                }else{
                    profits[i][j]=Math.max(profits[i-1][j],profits[i-1][j-nums[i-1]]+nums[i-1]*prices[i-1]);
                }
            }
        }
        return profits[nums.length][N];
    }
}
