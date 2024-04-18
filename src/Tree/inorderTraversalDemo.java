package Tree;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversalDemo {

    public void traversal(TreeNode root,List list){
        if (root == null) return;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);

    }
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root,list);

        return list;
    }
}
