package vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/9/11 15:57
 * @Created by luojia
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr );
        System.out.println(output);
    }

    private static int solution(String str) {
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==')'){
                //出栈
                stack.pop();
            }else if(str.charAt(i)=='('){
                //进栈
                stack.push(String.valueOf(str.charAt(i)));
            }else{
                break;
            }
        }
        return stack.size();
    }
}
