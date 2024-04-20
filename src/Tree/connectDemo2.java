package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class connectDemo2 {

    public Node2 connect(Node2 root) {
        Queue<Node2> queue=new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node2 node = queue.poll();

                if (i<size-1){
                    node.next=queue.peek();
                }

                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }
}
