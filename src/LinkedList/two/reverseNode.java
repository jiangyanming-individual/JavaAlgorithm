package LinkedList.two;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class reverseNode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            String[] str = line.split(",");

            ListNode head = new ListNode();
            // 头节点：
            head.val=Integer.parseInt(str[0]);
            for (int i=1;i<str.length;i++){
                ListNode tempNode=new ListNode(Integer.parseInt(str[i]));
                head.next=tempNode;
                head=tempNode;
            }
            ReverseList(head);
        }
    }
    public static  ListNode ReverseList (ListNode head) {
        // write code here
        if (head == null) return head;
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            // 翻转指针
            ListNode temp=cur.next;
            cur.next=pre;
            //指针前移：
            pre=cur;
            cur=temp;
        }
        System.out.println(pre.val);
        return pre;
    }
}
