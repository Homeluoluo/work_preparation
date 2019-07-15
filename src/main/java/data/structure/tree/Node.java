package data.structure.tree;

public class Node implements Comparable<Node>{
    private int val;
    private Node left;
    private Node right;

    public Node(int val){
        this.val=val;
    }
    public Node(int val, Node left, Node right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node node){
        return this.val-node.val;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
    }
}
