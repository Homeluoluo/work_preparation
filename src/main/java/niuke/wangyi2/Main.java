package niuke.wangyi2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/9/21 14:57
 * @Created by luojia
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int groupNum=Integer.parseInt(in.nextLine());
        for (int i = 0; i <groupNum; i++) {
            int x= Integer.parseInt(in.nextLine());
            System.out.println(getMinN(x));
        }
    }
    public static long getMinN(int x){
        long n=0;
        long i=1;
        while(x>0){
            if(x>9){
                n+=9*i;
            }else{
                n+=x*i;
            }
            i*=10;
            x=x-9;
        }
        return n;
    }
}
