package data.structure.tree.mytree;

import data.structure.tree.Node;

/**
 * @Classname TreeSolution
 * @Description TODO
 * @Date 2019/9/4 15:34
 * @Created by luojia
 */
public class TreeSolution {
    public static boolean treeEquals(TreeNode node1,TreeNode node2){
        if(node1.getValue()!=node2.getValue()){
            return false;
        }else{
            boolean left=false;
            boolean right=false;
            if (node1.getLeftChild()!=null&&node2.getRightChild()!=null){
                left=treeEquals(node1.getLeftChild(),node2.getRightChild());
            }else if(node1.getLeftChild()==null&&node2.getLeftChild()==null){
                left=true;
            }else{
                left=false;
            }
            if(!left){
                return false;
            }else{
                if (node1.getRightChild()!=null && node2.getRightChild()!=null){
                    right=treeEquals(node1.getRightChild(),node2.getRightChild());
                }else if(node1.getRightChild()==null&&node2.getRightChild()==null){
                    right=true;
                }else{
                    right=false;
                }
            }
            return right;
        }
    }

    public static void main(String[] args) {
        //判断 两颗二叉树是否相等
        //构建第一棵二叉树
        TreeNode node1_1=new TreeNode(1);
        TreeNode node1_2=new TreeNode(2);
        TreeNode node1_3=new TreeNode(3);
        TreeNode node1_4=new TreeNode(4);
        TreeNode node1_5=new TreeNode(5);

        node1_2.setRightChild(node1_4);
        node1_3.setRightChild(node1_5);
        node1_1.setLeftChild(node1_2);
        node1_1.setRightChild(node1_3);

        //构建第二棵二叉树
        TreeNode node2_1=new TreeNode(1);
        TreeNode node2_2=new TreeNode(2);
        TreeNode node2_3=new TreeNode(3);
        TreeNode node2_4=new TreeNode(4);
        TreeNode node2_5=new TreeNode(5);

        node2_1.setLeftChild(node2_2);
        node2_1.setRightChild(node2_3);
        node2_2.setRightChild(node2_4);
        node2_3.setRightChild(node2_5);

        System.out.println(treeEquals(node1_1,node2_1));
        System.out.println(isSubtree(node1_1,node2_1));
    }

    /**
     * 判断两树是否相等
     * @param l
     * @param r
     * @return
     */
    private static boolean isEqual(TreeNode l, TreeNode r){
        if(l == null && r == null)
            return true;//两树均空自然相等
         if(l == null || r == null)
             return false;//一空一非空，自然不等
         if(l.getValue() == r.getValue())//递归判断
              return isEqual(l.getLeftChild(),r.getLeftChild()) && isEqual(l.getRightChild(),r.getRightChild());
         return false;
    }
    /**
    *判断 t 树是否是 s 树的子树
     * * @param s
     * @param t
     * @return
    */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.value == t.value){
            return isEqual(s,t) || isSubtree(s.leftChild, t) || isSubtree(s.rightChild, t);
        } // 根节点不同，那么就不同考虑s和t相等的情形了
        return isSubtree(s.leftChild, t) || isSubtree(s.rightChild, t);
    }

}
