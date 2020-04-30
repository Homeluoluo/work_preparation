package niuke.tengxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main3
 * @Description TODO
 * @Date 2019/9/20 20:31
 * @Created by luojia
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int groupNum=Integer.parseInt(in.nextLine());
        for (int i = 0; i < groupNum; i++) {
            int length=Integer.parseInt(in.nextLine());
            List<Integer> battles=new ArrayList<>();
            String[] strings=in.nextLine().split(" ");
            for (int j = 0; j < length; j++) {
//                battles[i]=Integer.parseInt(strings[i]);
                battles.add(Integer.parseInt(strings[j]));
            }
            splitGroup(battles);
        }
    }

    public static void splitGroup(List<Integer> battles){
        Collections.sort(battles);
        int a=battles.get(battles.size()-1);
        int b=battles.get(battles.size()-2);
//        boolean groupA=
        for (int i = battles.size()-3; i >=1;) {
            if (a>b){
                b+=battles.get(i);
                a+=battles.get(i-1);
            }else{
                a+=battles.get(i);
                b+=battles.get(i-1);
            }
            i=i-2;
        }
        if(a>b){
            System.out.println(b+" "+a);
        }else{
            System.out.println(a+" "+b);
        }
    }

}
