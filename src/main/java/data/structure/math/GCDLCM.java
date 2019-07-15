package data.structure.math;

import java.util.Scanner;

/**
 * @Classname GCDLCM
 * @Description TODO
 * @Date 2019/4/5 10:31
 * @Created by luojia
 */
public class GCDLCM {

//    辗转相除法求最大公约数
    public static int get_gcd(int a, int b){
        int gcd=1;
        if(b>a){//如果b大于a，交换两个数的位置，保证a中存的是大的数
            int temp=a;
            temp=a;
            a=b;
            b=temp;
        }
        if(a%b!=0){
            while(a%b!=0){
                gcd = b;
                b = a%b;
                a=gcd;
            }
        }
//        gcd = b;
        return b;
    }
    //利用最大公约数和最小公倍数的性质求最小公倍数。
    public static int get_lcm(int a, int b){
        return a*b-get_gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("最大公约数："+get_gcd(a,b));
        System.out.println("最小公倍数："+get_lcm(a,b));
    }
}
