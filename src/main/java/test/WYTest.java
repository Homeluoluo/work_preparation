package test;

/**
 * @Classname WYTest
 * @Description TODO
 * @Date 2019/4/2 16:10
 * @Created by luojia
 */

import java.util.Scanner;

public class WYTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); sc.nextLine();
        int[][] map = new int[n][2];
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        for (int i=0;i<n;i++){
            map[i][0] = Integer.valueOf(str1[i]);
            map[i][1] = Integer.valueOf(str2[i]);
        }
        int resultMax = 0;
        int curMax = 0;
        int wake = 0; //醒着的时间获得的兴趣值
        for (int i=0;i<map.length;i++){
            if (map[i][1] == 1){
                wake += map[i][0];
            }
        }
        for (int i=0;i<map.length;i++){
            if (map[i][1] == 0){
                if (map[i][1] == 0){
                    //从 i 开始，往后加上 k 个数
                    curMax = getSum(map,i,k);
                    curMax = curMax+wake;
                }
                resultMax = Math.max(resultMax,curMax);
            }
        }
        resultMax = Math.max(resultMax,curMax);
        System.out.println(resultMax);
    }
    private static int getSum(int[][] map, int i,int k){
        int res = 0; //接下来的 k 包含当前吗？
        for (int j=0;j<k;j++){
            if (i+j<map.length){
                if (map[i+j][1] == 0)
                    res += map[i+j][0];
            }
        }
        return res;
    }
}
