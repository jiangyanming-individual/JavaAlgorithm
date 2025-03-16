package LiKoHot100.链表;

public class reverseKGroupDemo {


    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k){


        ListNode dummyHead= new ListNode(-1);
        dummyHead.next=head;

        ListNode cur =head;
        ListNode tail =dummyHead;
        ListNode temp=cur;

        while (cur!=null){

            int index=k;
            ListNode pre =tail;

            while (index>0 && temp!=null){
                pre=temp;
                temp=temp.next;
                index--;
            }
            if (index>0){
                tail.next=cur;
                break;
            }

            pre.next=null;
            tail.next=reverse(cur);
            tail=cur;
            cur=temp;
        }
        return dummyHead.next;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){

        ListNode pre=null, cur=head, next;

        while (cur!=null){

            next=cur.next;
            cur.next=pre;

            // pre前移一个位置，cur前一到cur
            pre =cur;
            cur=next;
        }

        return pre;
    }
}
