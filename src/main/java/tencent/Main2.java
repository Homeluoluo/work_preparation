package tencent;

import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/4/5 20:31
 * @Created by luojia
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= Integer.valueOf(scanner.nextLine());
//        int n=scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i]= scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            int length=0;
            StringBuilder str=new StringBuilder(strs[i]);
            while (!winOrNot(str.toString()).equals("")){
                String str1=winOrNot(str.toString());
                length +=str1.length();
                System.out.println(str1);
                str.toString().replace(str1,"");
                System.out.println(str.toString());
            }
            if (length/2%2==0){
                System.out.println("Oh,no.");
            }else{
                System.out.println("Yes,you can win!");
            }
            /*if(winOrNot(strs[i])){
                System.out.println("Yes,you can win!");
            }else{
                System.out.println("Oh,no.");
            }*/
        }
    }
    //转化为寻找所有的双数回文串
    public static String winOrNot(String str){
        char[] chars=str.toCharArray();
        int length=0;
        String result="";
        for (int i = 0; i < chars.length-1; i++) {
            int left=i;
            int right=i+1;
            while (left>=0&&right<chars.length){
                if(chars[left]==chars[right]){
                    if(right-left+1>length){
                        length=right-left+1;
                        result=str.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(length>0){
                System.out.println(result);
                System.out.println("length="+length);
            }
        }

        /*if (length/2%2==0){
            return false;
        }else{
            return true;
        }*/
        return result;
    }
}
