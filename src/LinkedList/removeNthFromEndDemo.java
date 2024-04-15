package LinkedList;

public class removeNthFromEndDemo {

    public ListNode removeNthFromEnd(ListNode head,int n){

        ListNode dummyHead=new ListNode(-1,head);
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;

        //fast前移n+1;
        int count=0;
        while (count<n){
            fast=fast.next;
            count++;
        }
        fast=fast.next;

        //fast当前节点不为空
        while (fast!=null){
            fast= fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummyHead.next;
    }

}
