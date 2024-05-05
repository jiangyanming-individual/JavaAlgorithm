package Tree;


/**
 * 递归的方法，右中左的去遍历；
 */
public class convertBSTDemo {

    private int pre=0; //前一个节点的val
    public TreeNode convertBST(TreeNode root){
        traversal(root);
        return root;
    }

    public void traversal(TreeNode cur){

        if (cur == null) return;
        //单层遍历：
        //右
        traversal(cur.right);
        //中；
        cur.val +=pre; //更新节点的值：
        pre=cur.val; //更新pre;
        //左：
        traversal(cur.left);

    }
}
