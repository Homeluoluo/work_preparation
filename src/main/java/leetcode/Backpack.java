package leetcode;

/**
 * @Classname Backpack
 * @Description 0-1背包问题
 * https://blog.csdn.net/jushang0235/article/details/78841915
 * https://blog.csdn.net/qq_38410730/article/details/81667885
 * @Date 2019/4/22 15:10
 * @Created by luojia
 */
public class Backpack {
    public static void main(String[] args) {
        int val[] = {200, 250, 140,150};
        int wt[] = {1, 3, 2,5};
        int W = 5;
        System.out.println(knapSack(W, wt, val, val.length));
    }
//    递归解法
    public static int knapSack(int W, int wt[], int val[], int n)
    {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);
        else
            return Math.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1)
        );
    }

// 动态规划
    public static int knapSack2(int W, int wt[], int val[], int n)
    {
        int i, w;
        int[][] K=new int[n+1][W+1];
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][W];
    }
}
