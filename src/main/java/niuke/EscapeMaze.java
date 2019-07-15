package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname EscapeMaze
 * @Description TODO
 * @Date 2019/4/7 10:53
 * @Created by luojia
 */
public class EscapeMaze {
    private static int m;
    private static int n;
    private static char[][] matrix;
    private static List<Integer> paths=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] mnString=sc.nextLine().split(" ");
        m=Integer.parseInt(mnString[0]);
        n=Integer.parseInt(mnString[1]);
        matrix=new char[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i]=sc.nextLine().toCharArray();
        }
        int p1=0,p2=0,q1=0,q2=0;//出入口坐标
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if (matrix[i][j] == '2') {
                    p1=i;
                    q1=j;
                }
                if (matrix[i][j]=='3'){
                    p2=i;
                    q2=j;
                }
            }
        }
        char[] keys=new char[10];
        walk(p1,q1,p2,q2,keys,0,0);
        System.out.println(paths);
    }

    public static void walk(int p1,int q1,int p2,int q2,char[] keys,int keyNum,int path){
        if(p1>0){
            int p=p1-1;
            choose(p,q1,p2,q2,keys,keyNum,path);
        }
        if(q1>0){
            int q=q1-1;
            choose(p1,q,p2,q2,keys,keyNum,path);
        }
        if(p1<m){
            int p=p1+1;
            choose(p,q1,p2,q2,keys,keyNum,path);
        }
        if(q1<n){
            int q=q1+1;
            choose(p1,q,p2,q2,keys,keyNum,path);
        }
    }

    public static void choose(int p1,int q1,int p2,int q2,char[] keys,int keyNum,int path){
//        遇到路
        if(matrix[p1][q1]=='1'){
            path++;
            walk(p1,q1,p2,q2,keys,keyNum,path);
        }
//        遇到钥匙
        if(Character.isLowerCase(matrix[p1][q1])){
            path++;
            keys[keyNum++]=matrix[p1][q1];
            walk(p1,q1,p2,q2,keys,keyNum,path);
        }
//        遇到门
        if(Character.isUpperCase(matrix[p1][q1])){
            for (int i = 0; i <keyNum ; i++) {
                if(keys[i]-matrix[p1][q1]==32){
                    path++;
                    walk(p1,q1,p2,q2,keys,keyNum,path);
                    break;
                }
            }
        }
//        遇到出口
        if(matrix[p1][q1]=='3'){
            path++;
            paths.add(path);
        }
        if(matrix[p1][q1]=='0'){
            System.out.println("遇到墙");
        }
    }
}
