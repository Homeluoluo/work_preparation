package data.structure.tree;

public class HuffmanNode implements Comparable<HuffmanNode> {
    private byte value;
    private int weight;
    private HuffmanNode left;
    private HuffmanNode right;
    public HuffmanNode(byte value,int weight){
        this.value=value;
        this.weight=weight;
    }
    public HuffmanNode(int weight){
        this.weight=weight;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode node){
        return this.weight-node.weight;
    }

    @Override
    public String toString() {
        return "Node{" + "val=" + value+", weight=" + weight  + ", left=" + left + ", right=" + right + '}';
    }
}
