package tencent1;

import java.util.Scanner;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2019/4/4 13:31
 * @Created by luojia
 */
/*
2018春招技术类编程题汇总 第1题
* */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long m=0;
        long n=0;
        if(sc.hasNext()){
            String[] inputs = sc.nextLine().split(" ");
            if(inputs.length!=2){
                System.out.println("输入不符合条件或无输入");
                return;
            }
            n = Integer.valueOf(inputs[0]);
            m = Integer.valueOf(inputs[1]);
        }
        if(m==0||n==0||n%(2*m)!=0){
            System.out.println("输入不符合条件或无输入");
            return;
        }

        long result=0;
//        int i=1;
//        while(i>n){
//
//        }
        for(int i=0;i<n/(2*m);i++){
            for(int j=0;j<m;j++){
                result = result+2*m*i+j+1;
//                System.out.println(result);
            }
        }
        System.out.println(result);
        result=n*(1+n)/2-2*result;
        System.out.println(result);
    }
}
