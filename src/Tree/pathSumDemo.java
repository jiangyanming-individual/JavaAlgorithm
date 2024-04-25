package Tree;

import java.util.ArrayList;
import java.util.List;

public class pathSumDemo {
    public List<List<Integer>> pathSum(TreeNode root,int targetSum){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        if (root ==null) return result; //如果为空，直接返回result

        paths.add(root.val);
        traversal(root,targetSum - root.val,result,paths);
        return result;
    }
    public void traversal(TreeNode node ,int count, List<List<Integer>> result,List<Integer> paths){

        //找到合适的路径就直接添加到结果集中
        if (node.left == null && node.right == null && count == 0){
            result.add(new ArrayList<>(paths)); //加入到结果集
            return;
        }
        if (node.left == null && node.right==null) return; //遇到叶子节点而没有找到合适的边，直接返回
        //单层递归调用；
        if (node.left!=null){
            paths.add(node.left.val);
            count -= node.left.val;
            traversal(node.left,count,result,paths); //递归
            count+=node.left.val; //回溯
            paths.remove(paths.size()-1); //回溯；
        }

        if (node.right!=null){
            paths.add(node.right.val);
            count-=node.right.val;
            traversal(node.right,count,result,paths);
            count+= node.right.val;//回溯
            paths.remove(paths.size()-1); //回溯；
        }
        return; //递归结果
    }
}
