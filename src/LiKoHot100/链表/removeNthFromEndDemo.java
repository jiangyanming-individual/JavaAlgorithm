package LiKoHot100.链表;

public class removeNthFromEndDemo {


    /**
     * 删除倒数第n个节点:
     * （1）使用双指针的思想： 快指针比慢指针间隔n个节点
     * （2）需要设置一个虚拟头结点，然后让快慢指针都指向这个虚拟头节点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){

        ListNode dummyHead =new ListNode(-1);
        dummyHead.next =head;
        ListNode fast = dummyHead;
        ListNode slow =dummyHead;

        for (int i=0;i<= n;i++){
            fast=fast.next;
        }

        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }

        // 当前慢指针已经指向要删除节点前一个节点：
        if (slow.next!=null){
            slow.next=slow.next.next;
        }
        return dummyHead.next;
    }

}
