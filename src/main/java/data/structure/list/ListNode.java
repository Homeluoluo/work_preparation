package data.structure.list;

/**
 * @Classname ListNode
 * @Description TODO
 * @Date 2019/4/30 13:37
 * @Created by luojia
 */
public class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
