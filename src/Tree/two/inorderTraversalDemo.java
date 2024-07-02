package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversalDemo {

    /**
     * 中序遍历
     * @param treeNode
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode treeNode){
        List<Integer> result=new ArrayList<>();
        tranversal(treeNode,result);
        return result;

    }
    public void tranversal(TreeNode treeNode,List<Integer> result){
        //递归终止条件
        if (treeNode == null){
            return;
        }
        //其他条件：
        tranversal(treeNode.left,result);
        result.add(treeNode.val);
        tranversal(treeNode.right,result);
    }

}
