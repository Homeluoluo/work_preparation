package zhaoshang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        //处理输入
        Scanner input = new Scanner(System.in);
        String[] nk=input.nextLine().split(" ");
        int n=Integer.parseInt(nk[0]);
        int k=Integer.parseInt(nk[1]);
        int[] row = new int[n];
        String[] rows= input.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            row[i] = Integer.parseInt(rows[i]);
        }
        if (judge(n,k,row)){
            //判断一开始是否满足条件
            System.out.println(0);
        }else{
            int handNum = 0;
            int result = 0;
            int a = Arrays.stream(row).sum()/n;
            int[] rowSort = Arrays.stream(row).sorted().toArray();
            rowSort[n-1]--;
            handNum+=1;
            result++;
            if (judge(n,k,rowSort)){
                System.out.println(result);
            }else{

            }
            for (int i = 0; ; i++) {

            }

        }
    }

    private static boolean judge(int n,int k,int[] row){
        Map<Integer,Integer> rowMap = new HashMap<>();
        for (int i = 0; i <n ; i++) {
            if (rowMap.containsKey(row[i])){
                rowMap.put(row[i],rowMap.get(row[i]+1));
            }else{
                rowMap.put(row[i],1);
            }
        }
        int maxCount = 0;
        for (int i = 0; i < rowMap.values().toArray().length; i++) {
            int a=(Integer)rowMap.values().toArray()[i];
            if (a>maxCount){
                maxCount=a;
            }
        }
        return maxCount>=k?true:false;
    }
}
