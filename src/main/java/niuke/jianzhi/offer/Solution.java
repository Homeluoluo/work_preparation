package niuke.jianzhi.offer;

import data.structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2019/5/22 22:37
 * @Created by luojia
 */
public class Solution {
//    计算二进制中1的个数
    public int NumberOf1(int n) {
        String resultBuMa="";
        if(n==0){
            return 0;
        }else{
            StringBuffer s=new StringBuffer();
            if(n<0){
                s.append("1");
                s.append(binary(-n));
                resultBuMa=bu(s.toString());
            }else{
                s.append("0");
                s.append(binary(n));
                resultBuMa=s.toString();
            }
        }
//        计算1的个数
        int numOfOne=0;
        char[] chars=resultBuMa.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='1'){
                numOfOne++;
            }
        }
        return numOfOne;
    }

//    转二进制
    public String binary(int n){
        StringBuffer result=new StringBuffer();
        while (n/2!=0){
            result.append(n%2);
            n=n/2;
        }
        result.append(n%2);
//        if (result.length()<)
//        位数不足补0
        return result.toString();
    }
//    求负数的补码
    public String bu(String s){
        char[] chars=s.toCharArray();
//        求反码 ： 除符号位之外按位取反
        for (int i = 1; i < chars.length; i++) {
            if (chars[i]=='0'){
                chars[i]='1';
            }else{
                chars[i]='0';
            }
        }
//       求补码
        boolean flag=false;
        for (int i = 1; i <chars.length ; i++) {
            if(flag) {
                if (chars[i] == '0') {
                    chars[i] = '1';
                } else {
                    chars[i] = '0';
                }
            }
            if(chars[i] == '1'){
                flag=true;
            }
        }
        StringBuffer result=new StringBuffer();
        for (int i = 0; i <chars.length;  i++) {
            result.append(chars[i]);
        }
        return result.toString();
    }
//求一个数的补码
    public static String bu2(int a) {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 32; i++) {
            // 0x80000000 是一个首位为1，其余位数为0的整数
             int t = (a & 0x80000000 >>> i) >>> (31 - i);
//             System.out.print(t);
            sb.append(t);
        }
//        System.out.println();
        return sb.toString();
    }

    public void reOrderArray(int [] array) {
        int partitionIndex=0;
        int temp=0;
        for (int i = 0; i < array.length; i++) {
            //遇到奇数
            if(array[i]%2!=0){
                temp=array[i];
                for (int j = i; j >partitionIndex ; j--) {
                    array[j]=array[j-1];
                }
                array[partitionIndex]=temp;
                partitionIndex++;
            }
        }

    }

//    剑指offer 判断一棵树是否为另一棵树的子树
//    方法一：递归检测
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null){
            return  false;
        }else{
            if(HasSubtree(root1.getLeft(),root2))
                return true;
            if(HasSubtree(root1.getRight(),root2))
                return false;
        }
        return false;
    }

    public boolean check(TreeNode root1, TreeNode root2) {
//        root2已经遍历完了
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1!=root2){
            return false;
        }
        return check(root1.getLeft(),root2.getLeft())&&check(root1.getRight(),root2.getRight());
    }

//    方法二：利用中序遍历

//    求一棵二叉树的镜像二叉树
    public void Mirror(TreeNode root) {
        root=mirrorTree(root);
    }

    public TreeNode mirrorTree(TreeNode root){
        if(root==null) return null;
        if(root.getLeft()!=null||root.getRight()!=null){
            TreeNode temp=root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        if (root.getLeft()!=null){
            root.setLeft(mirrorTree(root.getLeft()));
        }
        if(root.getRight()!=null){
            root.setRight(mirrorTree(root.getRight()));
        }

        return root;
    }

//    顺时针从外到内打印矩阵
    public List<Integer> printMatrix(int [][] matrix) {
        List<Integer> result=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0,j=0,p=m-1,q=n-1;
        int rowDirection=1;
        int round=1;
        if(m==1){
            while (j<=m-round){
                result.add(matrix[i][j]);
                j++;
            }
            return result;
        }
        if(n==1){
            while (i<=n-round){
                result.add(matrix[i][j]);
                i++;
            }
            return result;
        }
        while (round*2<=m&&round*2<=n){
//            向右
            if(rowDirection==1){
                while (j<=m-round){
                    result.add(matrix[i][j]);
                    j++;
                }
                rowDirection=2;
                j--;
                i++;
            }
//            向下
            if(rowDirection==2){
                while (i<=n-round){
                    result.add(matrix[i][j]);
                    i++;
                }
                rowDirection=3;
                i--;
                j--;
            }
//            向左
            if(rowDirection==3) {
                while (j >= round - 1) {
                    result.add(matrix[i][j]);
                    j--;
                }
                rowDirection = 4;
                j++;
                i--;
            }
//            向上
            if(rowDirection==4){
                while(i>round-1){
                    result.add(matrix[i][j]);
                    i--;
                }
                rowDirection=1;
                i++;
                j++;
            }
            round++;
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        /*int n=-5;
        System.out.println(s.NumberOf1(n));*/
       /* int[] array={1,2,3,4,5,6,7};
        s.reOrderArray(array);*/
//       测试顺时针打印矩阵
        int[][] a={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//        int[][] a2=new int[4][];
        List<Integer> result=s.printMatrix(a);
    }
}
