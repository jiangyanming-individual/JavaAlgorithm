package Tree.two;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class connectDemo {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                //查看是否有兄弟节点，有的话就是小于size -1个；
                if (i < size - 1) {
                    poll.next = queue.peek();
                }
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
        }
        return root;
    }
}
