package saima.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname Main1
 * @Description TODO
 * @Date 2019/4/13 20:20
 * @Created by luojia
 */
public class Main1 {
    public static List<Integer> counts=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] subStrs=new String[n];
        for (int i = 0; i < n; i++) {
            subStrs[i]=sc.nextLine();
        }
        String str=sc.nextLine();
        countStr(str,subStrs,0);
    }

    public static void countStr(String str,String[] subStrs,int count){
        int begin=0;
        int end=0;
        int length=str.length();
        int n=subStrs.length;
        String flag="";//记录从begin开始是否匹配到子串
//        int count=0;
        while (begin!=str.length()){
            count++;
            for (int i = 0; i < n; i++) {
                if(begin+subStrs[i].length()<length){
                    end=begin+subStrs[i].length();
                    if (str.substring(begin,end).equals(subStrs[i])){
                        flag=subStrs[i];
                        countStr(str.substring(end,str.length()-1),subStrs,count);
                        System.out.println(subStrs[i]);
                        begin=end;
                        break;
                    }
                }
            }
            if (!flag.equals("")){
                begin++;
            }
            flag="";
        }
//        return count;
    }
}
