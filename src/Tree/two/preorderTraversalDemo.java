package Tree.two;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversalDemo {


    /**
     * 前序遍历：
     * @param
     */
    public List<Integer> preorderTraversal(TreeNode treeNode){
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
        result.add(treeNode.val);
        tranversal(treeNode.left,result);
        tranversal(treeNode.right,result);
    }

}
