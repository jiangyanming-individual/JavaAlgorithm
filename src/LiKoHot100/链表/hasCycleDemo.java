package LiKoHot100.链表;

import org.w3c.dom.ls.LSInput;

import java.util.HashSet;
import java.util.List;

public class hasCycleDemo {


    /**
     * 1. 使用hashset来添加元素，来判断是否之前添加，如果之前添加过元素，就说明存在环，直接返回true
     * 2. 使用快慢指针，如果存在环的话，一定会有重合的地方。
     * 初始化fast和slow的时候，让slow=head， fast=head.next，避免初始化就碰到slow==fast
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head){

        HashSet<Integer> hashSet = new HashSet<>();
        ListNode cur =head;
        while (cur!=null){
            // 存在有环的情况
            boolean add = hashSet.add(cur.val);
            if (!add){
                return true;
            }
            cur=cur.next;
        }
        return false;

    }
    public boolean hasCycle2(ListNode head){

        // 特殊条件的判断
        if (head == null || head.next== null){
            return false;
        }
        ListNode slow= head;
        ListNode fast =head.next;
        while (slow!=fast){
            // 如果没有环
            if (fast == null || fast.next == null){
                return false;
            }
            slow=slow.next;
            //fast走两步
            fast=fast.next.next;
        }
        // 如果slow == fast说明有环了
        return true;
    }
}
