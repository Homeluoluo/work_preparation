package niuke.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Island
 * @Description TODO
 * @Date 2019/4/14 15:19
 * @Created by luojia
 */
public class Island {
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
        int[][] map=new int[m][];
        for (int i = 0; i < m ; i++) {
            map[i]=new int[n];
            String[] nums=inputs.get(i).split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(nums[j]);
            }
        }
        calIsland(map,0,0);
    }
    public static void setIsland(int[][] map,int i,int j){
        int m=map.length;
        int n=map[0].length;
        if(i<0||j>=m||map[i][j]!=1){
            return;
        }else{
            map[i][j]=2;
            calIsland(map,i+1,j);
            calIsland(map,i-1,j);
            calIsland(map,i,j+1);
            calIsland(map,i,j-1);
        }
    }

    public static int calIsland(int[][] map,int i,int j){
        int m=map.length;
        int n=map[0].length;
        if (m==0){
            return 0;
        }
        if (n==0){
            return 0;
        }
        int count=0;
        for (int k = 0; k <m ; k++) {
            for (int l = 0; l < n; l++) {
                if(map[k][l]==1){
                    count++;
                    setIsland(map,k,l);
                }
            }
        }
        return count;
    }
}
