package leetcode;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2019/3/16 14:37
 * @Created by luojia
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int length=s.length();
        int row=0,column=0;
        boolean flag=false;
        char result[][] =new char[numRows][length];
        for(int i=0;i<length;i++){
            result[row][column]=s.charAt(i);
            if(row==numRows-1){
                flag=true;
            }
            if(row==0){
                flag=false;
            }
            if(flag){
                row--;
                column++;
            }else{
                row++;
            }
        }
        String resultStr="";
        for(int i=0;i<numRows;i++){
            for(int j=0;j<length;j++){
                if(result[i][j]!='\0'){
                    resultStr+=result[i][j];
                }
            }
        }
        return resultStr;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        String resultStr=solution.convert("PAYPALISHIRING",3);
        System.out.println(resultStr);
    }
}
