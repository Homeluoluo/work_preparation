package vivo;

import data.structure.list.ListNode;

/**
 * @Classname ListTest
 * @Description TODO
 * @Date 2019/9/18 23:49
 * @Created by luojia
 */
public class ListTest {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

    }

    //遍历法
    public ListNode reverseList(ListNode listNode){
        //保存先前节点
        ListNode pre=null;
        //next用作临时变量
        ListNode next=null;
        while(listNode!=null){
            next=listNode.getNext();
            listNode.setNext(pre);
            pre=listNode;
            listNode=next;
        }
        return pre;
    }
}
