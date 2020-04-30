package niuke.tengxun;

import java.util.Scanner;

/**
 * @Classname Main1
 * @Description TODO
 * @Date 2019/9/20 20:00
 * @Created by luojia
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer groupNum=Integer.parseInt(in.nextLine());
        Integer[] lenArray=new Integer[groupNum];
        String[] phoneNums=new String[groupNum];
        for (int i = 0; i < groupNum; i++) {
            lenArray[i]=Integer.parseInt(in.nextLine());
            phoneNums[i]=in.nextLine();
        }
        for (int i = 0; i <groupNum ; i++) {
            if(canChangeToQQPhoneNumOrNot(phoneNums[i])){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean canChangeToQQPhoneNumOrNot(String str){
        if (str.length()<11){
            return false;
        }else{
            for (int i = 0; i <= str.length()-11; i++) {
                if(str.charAt(i)=='8'){
                    return true;
                }
            }
        }
        return false;
    }
}
