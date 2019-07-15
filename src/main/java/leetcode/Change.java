package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname Change
 * @Description 零钱兑换问题
 * @Date 2019/4/22 10:47
 * @Created by luojia
 */
public class Change {
    private static int min_num=999;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int amount=Integer.parseInt(sc.nextLine());
        int[] coins=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            coins[i]=Integer.parseInt(nums[i]);
        }
//        System.out.println(dp(coins,amount));
        System.out.println(coinChange(coins,amount));
    }

//    动态规划
    public static int dp(int[] coins,int amount){
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <amount+1 ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                if(i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]==amount+1){
            return -1;
        }else{
            return dp[amount];
        }
    }

//    宽度优先搜索
    public static void bfs(int[] coins,int amount){

    }

//    深度优先搜索
//继续搜索剩余的remainAmount
    public static boolean isCan(int[] coins, int remainAmount, int tempRes){
        if (remainAmount == 0){//搜索成功
            min_num = Math.min(min_num, tempRes);//更新
            return true;
        }
        else{
            boolean flag = false;
            //穷举所有金币
            for (int beginIndex = coins.length - 1; beginIndex >= 0; --beginIndex){
                if (remainAmount >= coins[beginIndex] && isCan(coins, remainAmount - coins[beginIndex], tempRes + 1)){
                    flag = true;
                }
            }
            return flag;
        }
    }

    public static int coinChange(int[] coins, int amount) {
        if (isCan(coins, amount, 0)){
            return min_num;
        }
        else{
            return -1;
        }
    }
}
