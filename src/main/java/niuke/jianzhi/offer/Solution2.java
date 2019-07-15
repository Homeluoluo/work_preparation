package niuke.jianzhi.offer;

/**
 * @Classname Solution2
 * @Description TODO
 * @Date 2019/4/29 23:03
 * @Created by luojia
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are family")));
    }

    public static String replaceSpace(StringBuffer str) {
        StringBuffer result=new StringBuffer();
        char[] chars=str.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                result.append("%20");
            }else{
                result.append(chars[i]);
            }
        }
        return result.toString();
    }
}
