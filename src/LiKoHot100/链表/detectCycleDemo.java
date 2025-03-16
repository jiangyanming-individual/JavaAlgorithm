package LiKoHot100.链表;

import java.util.HashSet;

public class detectCycleDemo {


    /**
     * 环形链表：
     * 1. 还是使用hashset进行判断
     * 2. 使用快慢指针的思想：
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast= head;
        ListNode slow =head;
        while (fast!=null &&  fast.next !=null){
            // 快指针移动2步，慢指针移动1步
            slow= slow.next;
            fast=fast.next.next;
            // 当快慢指针相遇了，
            if (slow == fast){
                // index1 指向头， index2 指向快慢指针相遇的地方
                ListNode index1 =head;
                ListNode index2= fast;
                while (index1 != index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                // 当两者相遇，就是环形的入口
                return index1;
            }
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head){

        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur =head;
        while (cur!=null){
            if (hashSet.contains(cur)){
                return cur;
            }else {
                hashSet.add(cur);
            }
            cur=cur.next;
        }
        return null;
    }
}
