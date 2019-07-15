package leetcode;/*
*
2.Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
* */

import java.util.List;

public class AddTwoNumbers {
    public static ListNode add_TwoNumbers(ListNode l1, ListNode l2) {
        int sum=l1.val+l2.val;
        ListNode node1=new ListNode(0);
        int flag=0;
        if (sum>=10){
            node1.val=sum%10;
            flag=1;
        }else{
            node1.val=sum;
            flag=0;
        }
        ListNode node=node1;

        while (l1.next!=null||l2.next!=null){
            if (l1.next!=null){
                l1=l1.next;
            }else{
                l1.val=0;
            }
            if (l2.next!=null){
                l2=l2.next;
            }else{
                l2.val=0;
            }
            System.out.println(node.val);
            ListNode temp=new ListNode(0);
            sum=l1.val+l2.val+flag;
            temp.val=sum%10;
            flag=sum/10;
            node.next=temp;
            node=node.next;
        }
        if (flag==1){
            ListNode temp=new ListNode(1);
            node.next=temp;
            node=node.next;
        }
        return node;
    }

    public static ListNode add_TwoNumbers2(ListNode l1, ListNode l2) {
        int num1=l1.val;int num2=l2.val;
        int i=1;int j=1;
        while (l1.next!=null){
            l1=l1.next;
            num1+=l1.val*Math.pow(10,i);
            i++;
        }
        while (l2.next!=null){
            l2=l2.next;
            num2+=l2.val*Math.pow(10,j);
            j++;
        }
        int result=num1+num2;
        ListNode node_root=new ListNode(result%10);
        ListNode node=node_root;
        while (result/10!=0){
            result=result/10;
            ListNode temp=new ListNode(result%10);
            node.next = temp;
            node = temp;
        }
        return node_root;
    }

    public static ListNode add_TwoNumbers3(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 遍历一个链表
     */
    public static void printListNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    public static void main(String args[]){
        ListNode node1=new ListNode(9);
//        node1.next=new ListNode(4);
//        node1.next.next=new ListNode(3);

        ListNode node2=new ListNode(1);
        node2.next=new ListNode(9);
        node2.next.next=new ListNode(9);
        node2.next.next.next=new ListNode(9);
        node2.next.next.next.next=new ListNode(9);

        printListNode(add_TwoNumbers3(node1,node2));
    }
}
