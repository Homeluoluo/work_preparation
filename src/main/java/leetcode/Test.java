package leetcode;

import data.structure.linkedList.LinkedList;
import data.structure.linkedList.LinkedListNode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

/*
* 约瑟夫问题
 * <p>
 * 人们站在一个等待被处决的圈子里。 计数从圆圈中的指定点开始，并沿指定方向围绕圆圈进行。
 * 在跳过指定数量的人之后，处刑下一个人。 对剩下的人重复该过程，从下一个人开始，
 * 朝同一方向跳过相同数量的人，直到只剩下一个人，并被释放。
 * <p>
 * 约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，
 * 第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
 * 例如N=6，M=5，被杀掉的顺序是：5，4，6，2，3。
* */
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //总人数M，报数间隔N
        Integer M = Integer.valueOf(input.nextLine());
        Integer N = Integer.valueOf(input.nextLine());
        if (M<N){
            return;
        }
        //循环链表
        LinkedList linkedList = new LinkedList(M);
        LinkedListNode current = linkedList.getHead();
        while (linkedList.getSize()>0){
            for (int i = 1; i <N-1 ; i++) {
                current = current.getNext();
            }
            System.out.println(current.getNext().getData());
            current.setNext(current.getNext().getNext());
            linkedList.setSize(linkedList.getSize()-1);
            current=current.getNext();
        }
    }
}
