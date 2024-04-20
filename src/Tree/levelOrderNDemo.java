package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderNDemo {

    public List<List<Integer>> levelOrder(Node root){

        ArrayList<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tempList.add(node.val);
                for (Node child : node.children) {
                    if (child!=null){
                        queue.add(child);
                    }
                }
            }
            result.add(tempList);
        }
        return result;
    }
}

