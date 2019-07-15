package niuke.jianzhi.offer;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2019/4/29 22:42
 * @Created by luojia
 */
public class Solution1 {

    public static boolean find(int num,int[][] arrays){
        int m=arrays.length;
        int n=arrays[0].length;
        /*int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;
        int mid1 = 0,mid2 = 0;
        while (left<right&&top<bottom){
            mid1=(left+right)/2;
            mid2=(top+bottom)/2;
            if(num==arrays[mid1][mid2])
                return true;
            if(num>arrays[mid1][mid2]){
                left=mid1+1;
                top=mid2+1;
            }else{
                right=mid1+1;
                bottom=mid2+1;
            }
        }*/
//
        int i=0;
        int j=n-1;
        while(i<m&&j>0){
            if(arrays[i][j]==num){
                return true;
            }
            if(num>arrays[i][j]){
                i++;
            }else{
                j--;
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
