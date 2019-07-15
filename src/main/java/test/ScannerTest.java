package test;

import java.util.Scanner;

/**
 * @Classname ScannerTest
 * @Description TODO
 * @Date 2019/4/2 18:45
 * @Created by luojia
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String str=sc.nextLine();
        String str2=sc.nextLine();
        System.out.println(n);
        System.out.println(k);
        System.out.println(str);
        System.out.println(str2);
    }
}
