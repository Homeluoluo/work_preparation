package saima.duxiaoman;

import java.util.*;

/**
 * @Classname Main2
 * @Description
 * 车辆过桥
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 有 N 辆车要陆续通过一座最大承重为 W 的桥，其中第 i 辆车的重量为 w[i]，通过桥的时间为 t[i]。要求： 第 i 辆车上桥的时间不早于第 i - 1 辆车上桥的时间；
 *
 * 任意时刻桥上所有车辆的总重量不超过 W。
 *
 * 那么，所有车辆都通过这座桥所需的最短时间是多少？
 *
 * 输入
 * 第一行输入两个整数 N、W（1 <= N、W <= 100000）。第二行输入 N 个整数 w[1] 到 w[N]（1 <= w[i] <= W）。第三行输入 N 个整数 t[1] 到 t[N]（1 <= t[i] <= 10000）。
 *
 * 输出
 * 输出一个整数，表示所有车辆过桥所需的最短时间。
 *
 *
 * 样例输入
 * 4 2
 * 1 1 1 1
 * 2 1 2 2
 * 样例输出
 * 4
 *
 * 提示
 * 样例解释
 * 不妨设第 1 辆车在 0 时刻上桥，则：
 * 第 2 辆车也可以在 0 时刻上桥；
 * 第 2 辆车在 1 时刻下桥，此时第 3 辆车上桥；
 * 第 1 辆车在 2 时刻下桥，此时第 4 辆车上桥；
 * 第 3 辆车在 3 时刻下桥；
 * 第 4 辆车在 4 时刻下桥，此时所有车辆都通过这座桥。
 * @Date 2019/9/29 19:52
 * @Created by luojia
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] strings=in.nextLine().split(" ");
        int N=Integer.parseInt(strings[0]);
        int W=Integer.parseInt(strings[1]);
        String[] stringsW=in.nextLine().split(" ");
        String[] stringsT=in.nextLine().split(" ");
        int[] w=new int[N];
        int[] t=new int[N];
        for (int i = 0; i < N ; i++) {
            w[i]=Integer.parseInt(stringsW[i]);
        }
        for (int i = 0; i < N ; i++) {
            t[i]=Integer.parseInt(stringsT[i]);
        }
        System.out.println(getMinPassTime(W,w,t));
    }

    private static int getMinPassTime(int W, int[] w, int[] t) {
        int time=0;
        int N=w.length;
        int currentW=0;
        int i = 0;

        Map<Integer,Integer> bridge=new HashMap<>();
        bridge.put(i,t[i]);
        currentW+=w[i];
        i++;
        while(bridge.size()>0&&i<N){
            for( ;i < N; i++) {
                if(currentW<W){
                    //第i辆车上桥
                    currentW+=w[i];
                    bridge.put(i,t[i]);
                }else{
                    break;
                }
            }
            while (currentW>=W){
                Set<Integer> outIndex=new HashSet<>();
                for (Integer index:bridge.keySet()){
                    bridge.put(index,bridge.get(index)-1);
                    if(bridge.get(index)<=0){
                        currentW-=w[index];
                        outIndex.add(index);
                    }
                }
                for (Integer index:outIndex){
                    bridge.remove(index);
                }
                time++;
            }
        }
        if(bridge.size()>0){
            int maxLeft=0;
            for (Integer index:bridge.keySet()){
                if(bridge.get(index)>maxLeft){
                    maxLeft=bridge.get(index);
                }
            }
            time+=maxLeft;
        }
        return time;
    }
}
