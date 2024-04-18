package Tree;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversalDemo {

    public void traversal(TreeNode root,List list){
        if (root == null) return;
        traversal(root.left,list);
        traversal(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root,list);

        return list;
    }

}
