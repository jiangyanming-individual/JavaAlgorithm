package LiKoHot100.链表;

public class swapPairsDemo {


    /**
     * 交换链表的两两节点： 每次对Node1 和node2进行交换节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){

        //设置虚拟头节点方便操作
        ListNode dummyHead =new ListNode(-1);
        dummyHead.next= head;
        // 设置移动的指针
        ListNode cur =dummyHead;
        while (cur.next!=null && cur.next.next!=null){

            ListNode node1= cur.next;
            ListNode node2=cur.next.next;
            // 当前节点的下一个指向是node2，
            cur.next=node2;
            node1.next= node2.next;
            node2.next= node1;
            // 让cur移动到node1这里
            cur = node1;
        }

        return dummyHead.next;

    }
}
