package ali;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/9 18:57
 * @Created by luojia
 */
public class Main {

    static String calculate(int m, int k) {
        int[] bianhaos=new int[m+1];
        StringBuilder result=new StringBuilder("");
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <= m; i++) {
            if(i<=4){
                bianhaos[i]=i+1;
            }else{
                bianhaos[i]=bianhaos[i-2]+bianhaos[i-3];
            }
        }
        result.append(bianhaos[m]);
        //求年份

        result.append(","+2024);
        //        翻转
        for (int i = 0; i < m; i++) {
            bianhaos[i]=reverse(bianhaos[i]);
            map.put(bianhaos[i],i);
        }
        Arrays.sort(bianhaos);
       /* for (int i = 0; i < m; i++) {
            System.out.println(bianhaos[i]);
        }*/
        result.append(","+map.get(bianhaos[m-(k-1)]));
        return result.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));

    }

    static int num(int m){
        if(m<=4) {
            return m;
        }else {
            return num(m-2)+num(m-3);
        }
    }

    static int reverse(int bianHao){
        int result=0;
        int n=0;
        while (bianHao!=0){
            n=bianHao%10;
            result=result*10+n;
            bianHao=bianHao/10;
        }
        return result;
    }
}
