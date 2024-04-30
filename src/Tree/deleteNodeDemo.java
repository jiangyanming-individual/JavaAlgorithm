package Tree;

/**
 * 感觉挺难的：
 */
public class deleteNodeDemo {
    /**
     * 递归删除节点：
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        //没有找到空节点：
        if (root == null) return root;
        //单层递归的逻辑, 符合节点逻辑的进行处理：
        if (root.val == key){
            if(root.left == null){
                return root.right;
            } else if (root.right == null){
                return root.left;
            } else if (root.left == null && root.right == null){
                return null;
            } else  {
                //找到右子树，最左边的节点；
                TreeNode cur=root.right;
                while (cur.left!=null){ //判定cur.left不为空；
                    cur=cur.left;
                }
                cur.left= root.left; //左节点赋值最左边的节点；
                root=root.right; //右节点更新为根节点；
            }

        }
        if (root.val > key) root.left=deleteNode(root.left,key); //左遍历
        if (root.val< key) root.right =deleteNode(root.right,key);//右遍历
        return root;  //最后返回root;
    }
}
