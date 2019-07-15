package data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution
 * @Description TODO
 * @Date 2019/5/2 0:19
 * @Created by luojia
 */
public class Solution {
    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};
        TreeNode tree=reConstructBinaryTree(pre,in);
        printAfter(tree);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        System.out.println(pre.length);
        System.out.println(in.length);
        int root = pre[0];
        TreeNode node=new TreeNode(root);
        int partition=0;
        for (int i = 0; i <in.length ; i++) {
            if(in[i]==root){
                partition=i;
                break;
            }
        }
        if(partition>0){
            int[] left_in=new int[partition];
            for (int i = 0; i < partition; i++) {
                left_in[i]=in[i];
            }
            int[] left_pre=new int[partition];
            for (int i = 1; i <= partition ; i++) {
                left_pre[i-1]=pre[i];
            }
            node.left=reConstructBinaryTree(left_pre,left_in) ;
        }

        if(partition<in.length-1){
            int[] right_in=new int[in.length-(partition+1)];
            for (int i = partition+1; i < in.length; i++) {
                right_in[i-partition-1]=in[i];
            }
            int[] right_pre=new int[right_in.length];
            for (int i = in.length-right_in.length; i <in.length ; i++) {
                right_pre[i-partition-1]=pre[i];
            }
            node.right=reConstructBinaryTree(right_pre,right_in) ;
        }
        return node;
    }

    public static void printAfter(TreeNode node){
        if (node.left!=null){
            printAfter(node.left);
        }
        if (node.right!=null){
            printAfter(node.right);
        }
        System.out.print(node.val+" ");
    }
}
