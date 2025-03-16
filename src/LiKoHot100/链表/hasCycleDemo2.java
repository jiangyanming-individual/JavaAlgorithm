package LiKoHot100.链表;

import java.util.HashSet;

public class hasCycleDemo2 {


    /**
     *  环形链表：
     * @param head
     * @return
     */
     public boolean hasCycle(ListNode head){


         HashSet<ListNode> listNodes = new HashSet<>();
         ListNode cur=head;

         if (cur == null || cur.next == null){
             return false;
         }

         while (cur!=null){
             //之前已经添加过了
             if (!listNodes.add(cur)){
                 return true;
             }
             cur=cur.next;
         }
         return false;
     }
}
