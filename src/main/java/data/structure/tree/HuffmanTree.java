package data.structure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    /*
    1.将每个数构造为一个树节点
    2.排序树节点
    3.取最小的两个节点组成树
    4.将组成的树的根节点放入原序列中排序
    5.再取两个最小的构成树，依次循环。
    */
    public Node createHuffmanTree(int[] values){
        List<Node> nodes=new ArrayList<>();
        for (int value:values){
            Node node=new Node(value);
            nodes.add(node);
        }
        Collections.sort(nodes);
//        int i=0;
        while (nodes.size()>1){
            Node node=new Node(nodes.get(0).getVal()+nodes.get(1).getVal());
            node.setLeft(nodes.get(0));
            node.setRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(node);
            Collections.sort(nodes);
//            i++;
//            System.out.println("i="+i);
//            for (Node node1:nodes){
//                System.out.println(node1.toString()+"/n");
//            }
        }
        return nodes.get(0);
    }

    public void printHuffmanTree(Node node){
        System.out.println(node.toString());
        if(node.getLeft()!=null){
            printHuffmanTree(node.getLeft());
        }
        if(node.getRight()!=null){
            printHuffmanTree(node.getRight());
        }
    }

    public static void main(String[] args){
        int[] values=new int[]{3,5,29,8,7,11,14,23};
        HuffmanTree tree=new HuffmanTree();
        Node node=tree.createHuffmanTree(values);
        tree.printHuffmanTree(node);
    }
}
