package LiKoHot100.树;

import java.util.ArrayList;
import java.util.List;

public class kthSmallestDemo {


    /**
     * 中序遍历 + 列表存储
     * @param root
     * @param k
     * @return
     */
    List<Integer> res =new ArrayList<>();
    public int kthSmallest(TreeNode root, int k){
        dfs(root);
        // 列表中的数
        return res.get(k-1);
    }

    public void dfs(TreeNode root ){

        if (root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
