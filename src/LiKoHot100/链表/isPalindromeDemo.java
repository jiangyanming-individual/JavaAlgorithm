package LiKoHot100.链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class isPalindromeDemo {


    /**
     * 1. 使用数组存储元素，然后在进行判断
     * 2. 使用栈先来存储，然后进行弹出栈和原来的链表进行从前到后的进行遍历
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head){

        List<Integer> list = new ArrayList<>();

        ListNode cur =head;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }

        int start =0;
        int end= list.size()-1;
        boolean res = isHuiWen(list, start, end);
        return res;

    }

    public boolean isHuiWen(List list,int start,int end){

        while (start<end){
            if (list.get(start)!=list.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head){
        Stack<Integer> stack = new Stack<>();

        ListNode cur= head;
        while (cur!=null){
            stack.add(cur.val);
            cur=cur.next;
        }
        ListNode p=head;
        while (p!=null){
            if (p.val!= stack.peek()){
                return false;
            }
            p=p.next;
            stack.pop();
        }
        return true;
    }
}
