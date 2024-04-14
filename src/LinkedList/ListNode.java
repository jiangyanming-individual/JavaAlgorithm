package LinkedList;

public class ListNode {

    //默认访问修饰，是同一个类或者同一个包下可访问
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
