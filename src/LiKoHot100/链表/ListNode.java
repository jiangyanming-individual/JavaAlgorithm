package LiKoHot100.链表;

import java.util.List;

/**
 * 定义链表的节点：
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
        next=null;
    }

}
