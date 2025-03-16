package LiKoHot100.链表;

public class addTwoNumbersDemo {


    /**
     * 两数相加的操作: ，引入一个进位的思想，两数相加，如果和超过10 ，就进1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers (ListNode l1, ListNode l2){

        ListNode dummyHead =new ListNode(-1);
        // 移动指针节点：
        ListNode curHead =dummyHead;
        // 进位
        int carry =0;
        // 链表有可能是不等长的:
        while (l1!=null || l2!=null){
            // 遍历获取链表节点：也有可能当前节点是空的节点，当节点为空的时候，直接设置为0；
            int n1 = l1 !=null ? l1.val : 0;
            int n2 = l2 !=null ? l2.val : 0;
            int sum =n1 + n2 + carry;
            // 创建新的节点：sum取余数，
            curHead.next=new ListNode(sum % 10);
            // 移动指针
            curHead=curHead.next;
            // sum进行取商的操作：
            carry = sum / 10 ;
            // 让下面的链表进行遍历
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        // 最后一位 如果存在进位的话
        if (carry>0){
            curHead.next =new ListNode(carry);
        }
        // 返回头结点：
        return dummyHead.next;
    }
}
