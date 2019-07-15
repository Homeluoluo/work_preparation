package test;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname RegexTest
 * @Description TODO
 * @Date 2019/4/5 15:20
 * @Created by luojia
 */
public class RegexTest {
    public static void main(String args[]){
//        patternTest();
//        matcherTest();
        String str="luo jia MA-700's";
        String[] words=str.split("[\\p{Punct}\\s+]");
        for(String word:words){
            System.out.println(word);
        }
        String regex="\\[`!@#$%^&*()_+-=;':]";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);

        //调用
        String booksName = "《金瓶梅》、《苍空记》、《QQ传》";
        getRegEx(booksName ,"[\\pP\\p{Punct}]");
//        getRegEx(booksName ,"《(.*?)》");
    }

    public static void getRegEx(String originalText,String regEx ){
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(originalText);
        while(mat.find()){
            System.out.println("匹配出来："+mat.group(0)+" "+mat.start(0)+" "+mat.end(0));
        }
    }

    public static void patternTest(){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
    public static void matcherTest(){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
