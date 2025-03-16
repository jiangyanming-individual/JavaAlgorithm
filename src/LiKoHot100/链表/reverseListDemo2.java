package LiKoHot100.链表;

public class reverseListDemo2 {


    /**
     * 反转当前指针的下一个next节点，pre节点和cur节点后往后移动
     最后返回pre节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){

        ListNode pre =null;
        ListNode cur =head;

        while (cur!=null){
            ListNode tempNode =cur.next;
            cur.next= pre;
            // pre 和cur节点往后移动， pre移动到cur的位置，cur移动到cur.next的位置。
            pre= cur;
            cur=tempNode;
        }
        // 返回pre节点：
        return pre;
    }

}
