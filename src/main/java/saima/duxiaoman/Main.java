package saima.duxiaoman;

import java.util.Scanner;

/**
 * @Classname Main
 * @Description
 * 题目描述：
 * “你可曾听闻一招从天而降大掌法？”
 *
 *   在一部游戏中有这样一个技能，假设地图是一条直线，长度为n，人物所处的位置是x，则可以对x，2*x和2*x+1三格内的敌人分别造成一点伤害，要求2*x+1<=n。
 *
 *   设为这个地图的格子做标记为1-n，第i个格子中有一个血量为a_i的敌人。请问你至少使用多少次技能，可以杀死这个地图上所有敌人。
 *
 * 输入
 * 输入第一行包含一个正整数n,表示格子的数量(1<=n<=100)
 *
 * 输入第二行包含n个正整数a_i,表示第i个格子中敌人的血量。
 *
 * 输出
 * 输出仅包含一个正整数，即至少使用多少次技能。
 *
 *
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 样例输出
 * 8
 * @Date 2019/9/29 19:28
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] a=new int[n];
        for (int i = 0; i <n; i++) {
            a[i]=in.nextInt();
        }
        System.out.println(getAtackTime2(a));
    }

    private static int getAtackTime(int[] a) {
        int atack=0;
        int n=a.length;
        int i = 1;
        //在允许攻击的范围内攻击敌人
        for (; 2*i +1 <= n; i++) {
            while(a[i-1]>0){
                a[i-1]--;
                a[2*i-1]--;
                a[2*i]--;
                atack++;
            }
        }
        //分组求剩余敌人血量的最大值
        i = 1;
        for (; 2*i +1 <= n; i++) {
            atack+=Math.max(Math.max(a[i-1],a[2*i-1]),a[2*i]);
        }
        return atack;
    }

    private static int getAtackTime2(int[] a) {
        int atack=0;
        int n=a.length;
        //在允许攻击的范围内攻击敌人
        for (int i = 1; 2*i +1 <= n; i++) {
            while(a[i-1]>0){
                a[i-1]--;
                a[2*i-1]--;
                a[2*i]--;
                atack++;
            }
        }
        for (int i = 1; 2*i +1 <= n; i++) {
            while(a[2*i-1]>0){
                a[2*i-1]--;
                a[2*i]--;
                atack++;
            }
        }
        for (int i = 1; 2*i +1 <= n; i++) {
            while(a[2*i]>0){
                a[2*i]--;
                atack++;
            }
        }
        return atack;
    }
}
