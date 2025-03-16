package LiKoHot100.链表;

public class mergeTwoListsDemo {

    /**
     * 合并两个有序的链表：创建一个虚拟头节点，然后让链表a和链表b进行比较大小，然后依次遍历链表即可。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1,  ListNode list2){


        // 特殊情况，有个链表为null时，直接返回另一个链表
        if (list1== null && list2!=null){
            return list2;
        }
        if (list1!=null && list2 == null){
            return list1;
        }
        // 使用虚拟头结点：
        ListNode dummyHead =new ListNode(-1);
        ListNode cur =dummyHead;

        while (list1!=null && list2!=null){
            // 比较大小
            if (list1.val < list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next =list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        // 看谁先遍历完，谁先遍历完，那后面直接将下面的元素进行合并起来就行了
        cur.next = list1 == null? list2: list1;
        return dummyHead.next;
    }
}
