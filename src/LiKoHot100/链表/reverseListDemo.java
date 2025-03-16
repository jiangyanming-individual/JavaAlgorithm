package LiKoHot100.链表;

public class reverseListDemo {


    /**
     * 反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){


        ListNode pre=null;
        ListNode cur=head;
        // 当前节点不为空
        while (cur!=null){
            ListNode next =cur.next;
            // 反转
            cur.next =pre;
            // pre 和cur指针前移
            pre =cur;
            cur =next;
        }
        return cur;
    }
}
