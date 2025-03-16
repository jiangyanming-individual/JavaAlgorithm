package LiKoHot100.链表;

import java.util.HashMap;

public class copyRandomListDemo2 {


    public Node copyRandomList(Node head){
        // hashmap
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node cur = head;
        // 遍历并将所有的节点存储起来：
        while (cur!=null){
            nodeNodeHashMap.put(cur,new Node(cur.val));
            // 指针往下移动
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            nodeNodeHashMap.get(cur).next=nodeNodeHashMap.get(cur.next);
            // 也是设置下一个节点；
            nodeNodeHashMap.get(cur).random=nodeNodeHashMap.get(cur.random);
            // 指针往下移动
            cur=cur.next;
        }
        return nodeNodeHashMap.get(head);
    }
}
