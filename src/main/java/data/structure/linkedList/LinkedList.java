package data.structure.linkedList;

import java.util.List;

//单向循环链表
public class LinkedList {
    private LinkedListNode head;
    private int size;
    private LinkedListNode tail;

    public LinkedList(LinkedListNode head, Integer size) {
        this.head = head;
        this.size = size;
        this.tail = head;
    }

    public LinkedList(int size){
        this.size=size;
        LinkedListNode myHead = new LinkedListNode(1,null);
        this.head=myHead;
        for (int i = 2; i < size+1; i++) {
            myHead.setNext(new LinkedListNode(i,null));
            myHead = myHead.getNext();
        }
        myHead.setNext(head);
        tail = myHead;
    }

    //加入节点到链表尾部
    public void addNode(LinkedListNode node){
        /*LinkedListNode current = head;
        for (int i = 0; i < this.size-1; i++) {
            current = current.getNext();
        }
        node.setNext(head);
        current.setNext(node);*/
        node.setNext(head);
        tail.setNext(node);
        size++;
        tail=tail.getNext();
    }
    //删除指定位置节点
    public LinkedListNode delNode(int index){
        LinkedListNode current = head;
        if (index==0){
            size=0;
            head=null;
            return current;
        }else{
            for (int i = 0; i < this.size-1; i++) {
                current = current.getNext();
            }
            LinkedListNode next = current.getNext();
            current.setNext(next.getNext());
            //如果删除的是最后一个节点，改变尾部指针
            if (index == size-1){
                tail=current;
            }
            size--;
            return next;
        }
    }

    //获取指定位置节点
    public void getNode(int index){

    }

    public LinkedListNode getHead() {
        return head;
    }

    public void setHead(LinkedListNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
