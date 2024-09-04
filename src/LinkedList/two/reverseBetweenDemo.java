package LinkedList.two;

public class reverseBetweenDemo {

    public static void main(String[] args) {

    }
    public static ListNode reverseBetween (ListNode head, int m, int n) {


        // 虚拟头结点；
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;

        ListNode pre=dummyHead;
        ListNode cur=dummyHead.next;
        for (int i=1;i<m;i++){
            // pre前移一个节点
            pre=cur;
            // cur 前移一个节点：
            cur=cur.next;
        }

        for (int i=m;i<n;i++){
            // cur的下一个节点；
            ListNode temp=cur.next;
            //存储temp的下一个节点；
            cur.next=temp.next;
            // temp反转指向 cur;
            temp.next=pre.next;
            pre.next=temp;
        }
        // 去掉虚拟头节点；
        return dummyHead.next;
    }
}
