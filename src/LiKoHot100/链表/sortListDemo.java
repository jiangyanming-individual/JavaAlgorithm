package LiKoHot100.链表;

import java.util.List;

public class sortListDemo {


    /**
     * 排序链表 ： 使用递归 + 归并排序算法， 将链表拆分成2个子链表，对两个字链表进行排序，最后再进行合并操作。
     * @param head
     * @return
     */
    public  ListNode sortList(ListNode head){
        //递归实现，递归终止条件
        if (head == null || head.next == null){
            return head;
        }

        // 找到左右子链表的头
        ListNode mid =findMiddle(head);
        ListNode rightHead= mid.next;
        // 断开链表
        mid.next=null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        //合并两个有序的链表
        return mergeTwoLists(left,right);
    }

    public ListNode findMiddle(ListNode head){
        ListNode slow =head;
        ListNode fast =head.next;
        while (fast!=null && fast.next!=null){
            // 每次慢指针移动一步，快指针移动2步，当快指针移动到末尾，slow刚好移动到中间节点
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //执行的归并的操作
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){

        ListNode dummyHead=new ListNode(-1);
        ListNode cur =dummyHead;
        // 当前条件：如果两个子链表都不为空，有一个为空直接退出：
        while (l1!=null && l2!=null){
            // 比较节点大小：
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next=l2;
                l2=l2.next;
            }
            //当前指针后移
            cur=cur.next;
        }
        // 将剩余节点连接起来, 三元运算
        cur.next = l1 == null ? l2 : l1;
        // 返回结果集
        return dummyHead.next;
    }

}
