package LiKoHot100.链表;

import java.util.ArrayList;
import java.util.List;

public class isPalindromeDemo2 {

    /**
     * 1. 使用数组存储元素，然后在进行判断是否是回文
     * 2. 使用栈先来存储，然后进行弹出栈和原来的链表进行从前到后的进行遍历，挨个进行比对就可以
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode cur=head;
        while (cur!=null){
            list.add(cur.val);
        }
        int start =0;
        int end = list.size()-1;
        boolean huiWen = isHuiWen(list, start, end);
        return huiWen;

    }

    /**
     * 使用快慢指针
     * @param list
     * @param start
     * @param end
     * @return
     */
    public boolean isHuiWen(List list, int start, int end){
        while (start<end){
            if (!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
