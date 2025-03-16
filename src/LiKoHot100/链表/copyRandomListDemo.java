package LiKoHot100.链表;

import java.util.HashMap;
import java.util.HashSet;

public class copyRandomListDemo {


    /**
     * 随机链表的复制: 进行两次遍历操作，第一次遍历设置节点，第二次，设置节点和random
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        HashMap<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node cur =head;
        while (cur!=null){
            nodeNodeHashMap.put(cur,new Node(cur.val));
            cur=cur.next;
        }

        cur=head;

        while (cur!=null){
            nodeNodeHashMap.get(cur).next=nodeNodeHashMap.get(cur.next);
            nodeNodeHashMap.get(cur).random= nodeNodeHashMap.get(cur.next);
            cur=cur.next;
        }
        // 获取节点
        return nodeNodeHashMap.get(head);
    }
}
