package niuke;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname DistributeChocolate
 * @Description TODO
 * @Date 2019/4/7 10:23
 * @Created by luojia
 */
public class DistributeChocolate {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        小朋友信息输入
        int n=Integer.parseInt(sc.nextLine());
        String[] hString=sc.nextLine().split(" ");
        int[] hs=new int[n];
        for (int i = 0; i < n; i++) {
            hs[i]=Integer.parseInt(hString[i]);
        }
        //巧克力信息输入
        int m=Integer.parseInt(sc.nextLine());
        hString=sc.nextLine().split(" ");
        int[] ws=new int[m];
        for (int i = 0; i < m; i++) {
            ws[i]=Integer.parseInt(hString[i]);
        }
        Arrays.sort(hs);
        Arrays.sort(ws);
        int result=0;
        for (int i = m-1; i >=0;) {
            if (n<=0){
                break;
            }
            if(ws[i]>=hs[n-1]){
                result++;
                i--;
            }
            n--;
        }
        System.out.println(result);
    }
}
