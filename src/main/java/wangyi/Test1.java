package wangyi;

import jdk.nashorn.internal.runtime.regexp.RegExp;
import jdk.nashorn.internal.runtime.regexp.RegExpMatcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2019/4/2 19:02
 * @Created by luojia
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(str.split(""));
        String[] words=str.split(" ");
        StringBuilder result=new StringBuilder();
        String pattern = "[\\pP\\p{Punct}]";
//        Pattern.matches(pattern,"ljk,");
        Pattern p=Pattern.compile(pattern,1);
        for (int i = words.length-1; i >=0 ; i--) {
            String word = words[i];
            Matcher m=p.matcher(word);

            if(m.find()){
                System.out.println(wordDeal(word,m));
                result.append(wordDeal(word,m));
            }else{
                result.append(word);
            }
            result.append(" ");
        }
        System.out.println(result.toString());
    }

    public static String wordDeal(String word,Matcher m){
        StringBuilder result=new StringBuilder();
        String[] words=new String[10];
        int i=0;
        int begin=0;
        int end=0;
        while (m.find()){
            System.out.println(m.group());
            end=m.start();
            words[i]=word.substring(begin,end);
            words[i+1]=m.group();
            begin=m.end();
            i=i+2;
        }
        if (end!=begin){
            words[i]=word.substring(begin);
            i++;
        }
        for (int j = i-1; j >=0; j--) {
            result.append(words[j]);
        }
        return result.toString();
    }
}
