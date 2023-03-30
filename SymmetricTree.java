package Novice_class;
// 镜面树
public class SymmetricTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null ^ root.right == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        // 有左右子树
        return isSameTree(root.left,root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null ^ q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        //有左右节点
        boolean headTree = p.val == q.val ? true : false;
        boolean LTree = isSameTree(p.left,q.right);
        boolean RTree = isSameTree(p.right,q.left);
        return headTree && LTree && RTree;
    }
}
