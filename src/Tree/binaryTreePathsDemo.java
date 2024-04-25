package Tree;
import java.util.ArrayList;
import java.util.List;

public class binaryTreePathsDemo {

    /**
     * 前序遍历 +递归 + 回溯算法
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root){
        List<String> resultList = new ArrayList<>();
        ArrayList<Integer> paths = new ArrayList<>();
        if (root == null) return resultList;
        traversal(root,paths,resultList);
        return resultList;
    }

    public void traversal(TreeNode node,List<Integer> paths,List<String> res){

        paths.add(node.val);//中，先放入结果集
        //递归终止条件：
        if (node.left == null && node.right == null){

            StringBuilder sb = new StringBuilder();
            //前size-1个节点进行连接；
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            //加入路径的最后一个元素；
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());//添加到结果集中；
            return;
        }

        //单层递归条件
        if (node.left!=null){
            traversal(node.left,paths,res);
            paths.remove(paths.size()-1);//移除最后一个，进行回溯
        }

        if (node.right!=null){
            traversal(node.right,paths,res);
            paths.remove(paths.size()-1);//移除最后一个，进行回溯 (index)
        }
    }
}
