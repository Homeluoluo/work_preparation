package dynamic.programming;

/**
 * @Classname BackpackProblem
 * @Description TODO
 * @Date 2019/6/4 21:05
 * @Created by luojia
 */
public class BackpackProblem {
    public static void main(String[] args) {
        int total=1000;
        int[] prices={200,350,170,220,310,150};
        int[] values={300,100,80,240,290,220};
       /* int total=10;
        int[] prices={2,3,1,2,3,4};
        int[] values={30,10,80,24,29,22};*/
        purchase(total,prices,values);
    }

    public static void purchase(int total,int[] prices,int[] values){
        int n=prices.length;
        int[][] hot=new int[n+1][total+1];
        //初始化矩阵
        for (int i = 0; i < n+1; i++) {
            hot[i][0]=0;
        }
        for (int j = 0; j < total+1; j++) {
            hot[0][j]=0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < total+1; j++) {
                if(prices[i-1]<=j){
                    if (hot[i - 1][j] < (hot[i - 1][j - prices[i - 1]] + values[i - 1]))
                        hot[i][j] = hot[i - 1][j - prices[i - 1]] + values[i - 1];
                    else
                        hot[i][j] = hot[i - 1][j];
                }else{
                    hot[i][j]=hot[i-1][j];
                }
//                System.out.println(hot[i][j]);
            }
        }
        System.out.println(hot[n][total]);
    }
}
