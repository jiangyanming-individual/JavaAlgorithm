package test;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static ListNode findKthFromEnd(ListNode head, int k){

        ListNode dummaryHead = new ListNode(-1);
        dummaryHead.next=head;
        ListNode fast=dummaryHead;
        ListNode slow=dummaryHead;

        // 快指针移动k个位置
        for (int i=0;i<k;i++){
            if (fast == null){
                return null;
            }
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // 返回倒数k的节点
        return slow.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

