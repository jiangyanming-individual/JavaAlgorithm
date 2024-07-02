package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversalDemo {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();

        if (root == null){
            return result;
        }
        traversal(root,result);
        return result;
    }
    //递归参数
    public void traversal(TreeNode root,List<Integer> result){
        //递归终止条件
        if (root == null){
            return;
        }
        //子递归条件：
        traversal(root.left,result);
        traversal(root.right,result);
        result.add(root.val);
    }
}
