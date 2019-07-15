package niuke.shenxinfu;

import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/5/25 8:53
 * @Created by luojia
 */
//3 2
//15623651459
//18956036508
//18625690367
//333
//036
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int numOfPhone=Integer.parseInt(line1[0]);
        int numOfQuery=Integer.parseInt(line1[1]);
        String[] phones=new String[numOfPhone];
        for (int i = 0; i < numOfPhone; i++) {
            phones[i]=sc.nextLine();
        }
//        String[] querys=new String[numOfQuery];
        for (int i = 0; i < numOfQuery; i++) {
//            querys[i]=sc.nextLine();
            System.out.println(query(phones,sc.nextLine()));
        }
    }

    public static int query(String[] phones,String query){
        int result=0;
        for(String str:phones){
            if(str.substring(0,11).contains(query)){
                result++;
            }
        }
        return result;
    }
}
