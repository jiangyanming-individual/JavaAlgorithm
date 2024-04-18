package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversalDemo {


    public void  traversal(TreeNode root,List list){
        //单层结束条件
        if (root == null) return;
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);

    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

}
