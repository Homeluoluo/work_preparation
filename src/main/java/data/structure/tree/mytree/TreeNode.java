package data.structure.tree.mytree;

/**
 * @Classname TreeNode
 * @Description 二叉树节点
 * @Date 2019/5/21 18:50
 * @Created by luojia
 */
public class TreeNode<T>{
    T value;
    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
