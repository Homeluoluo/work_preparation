package leetcode;

/*找出最长的回文串
* */
public class Palindrome {

    public static String longestPalindrome(String str){
        int len=str.length();
        if(len==1){
            return str;
        }else{
            String result="";
            String temp="";
            for(int i=0;i<str.length();i++){
                for(int j=i+1;j<=str.length();j++){
                    temp=str.substring(i,j);
                    if(isPalindrome(temp)){
                        if(temp.length()>result.length()) {
                            result = temp;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome2(String str){
        String result="";
//        String temp="";
        int len=str.length();
        for(int i=0;i<len;i++){
            int left=i;
            int right=i;
            while(left>=0&&right<len){
                if(str.charAt(left)==str.charAt(right)){
                    if(right-left>result.length()-1){
                        result=str.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }

            }
            left=i;
            right=i+1;
            while(left>=0&&right<len){
                if(str.charAt(left)==str.charAt(right)){
                    if(right-left>result.length()-1){
                        result=str.substring(left,right+1);
                    }
                    left--;
                    right++;
                }else{
                    break;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        String a="bab";
        System.out.println(longestPalindrome2(a));

    }
}
