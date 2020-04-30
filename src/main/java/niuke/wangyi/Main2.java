package niuke.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/9/20 17:20
 * @Created by luojia
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Main2 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer size=in.nextInt();
        ListNode head=null;
        ListNode current=null;
        for (int i = 0; i <size ; i++) {
            ListNode node = new ListNode(in.nextInt());
            if(head==null){
                head=node;
                current=head;
            }else{
                current.next=node;
                current=current.next;
            }
        }
        printList(removeDuplicates(head));
    }

    public static ListNode removeDuplicates(ListNode head){
        Map<Integer,Integer> map=new HashMap<>();
        if(head==null||head.next==null){
            return head;
        }
        ListNode result=head;
        ListNode listNode=head;
        map.put(listNode.val,1);
        while (listNode.next!=null){
            ListNode pre=listNode;
            listNode=listNode.next;
            if (!map.containsKey(listNode.val)){
                map.put(listNode.val,1);
            }else if(map.get(listNode.val)==2){
                pre.next=listNode.next;
                listNode=pre;
            }else{
                map.put(listNode.val,2);
            }
        }
        return result;
    }

    public static void printList(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
    }
}
