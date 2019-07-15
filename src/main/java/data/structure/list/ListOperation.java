package data.structure.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Classname ListOperation
 * @Description TODO
 * @Date 2019/4/30 13:38
 * @Created by luojia
 */
public class ListOperation {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList();
        while (listNode!=null){
            list.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(list);
        return list;
    }

//    交换链表中的两个节点
    public ListNode exchange(ListNode head,int m,int n){
        if(head==null||head.next==null){
            return head;
        }
        int i=1;
//        p1为第m-1个节点 q1为第n-1个节点
        ListNode p1,p2,q1,q2;
        p1=head;
        while (i<m){
            p1=p1.next;
        }
        p2=p1.next;
        q1=p2;
        while (i<n){
            q1=q1.next;
        }
        q2=q1.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
