package LinkedList;

public class reverseListDemo {


    public ListNode reverseList(ListNode head){

        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode tempNode= cur.next;
            //cur指向pre
            cur.next=pre;
            //pre 和cur一起前移；
            pre=cur;
            cur=tempNode;
        }
        return pre;
    }

}
