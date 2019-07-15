package saima.weizhong;

import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/4/11 20:23
 * @Created by luojia
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k,m;
        n=sc.nextInt();
        k=sc.nextInt();
        m=sc.nextInt();
        int result=0;
        if(m>=n){
            result=k;
        }else {
            if(n*k%m==0){
                result=n*k/m;
            }else{
                result=n*k/m+1;
            }
        }
        System.out.println(result);
    }
}
