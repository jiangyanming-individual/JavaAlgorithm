package Tree.two;

public class deleteNodeDemo {

    /**
     * 删除树上的节点：
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                //一直遍历到右子树的最左叶子节点
                while (cur.left != null) {
                    cur = cur.left;
                }
                //左子树补充为最左叶子节点；
                cur.left = root.left;
                //右子树补充为根节点；
                root = root.right;
                return root;
            }

        }

        //左
        if (root.val > key) {
            root.left=deleteNode(root.left, key);
        }
        //右
        if (root.val < key) {
            root.right=deleteNode(root.right, key);
        }
        return root;
    }
}
