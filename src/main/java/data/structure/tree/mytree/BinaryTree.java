package data.structure.tree.mytree;

import java.util.List;

/**
 * @Classname BinaryTree
 * @Description 普通二叉树
 * @Date 2019/5/21 18:58
 * @Created by luojia
 */
public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    //    计算树的节点个数
    public int getNodeNum(){
        return 0;
    }
//    计算树的深度
    public int getHeight(){
        return 0;
    }
//    前序遍历
    public List<T> preOrder(){
        return null;
    }
//    中序遍历
    public List<T> inOrder(){
        return null;
    }
//    后序遍历
    public List<T> postOrder(){
        return null;
    }
//    获取父节点
    public TreeNode<T> getParent(){
        return null;
    }
}
