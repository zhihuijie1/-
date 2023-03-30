package Novice_class;
// 相同的树
public class SameTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 异或：(p == null q != null) (p != null q == null )自由这两中情况，条件才会是true
        if(p == null ^ q == null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }
        // 都不为null
        Boolean headTree = p.val == q.val ? true : false;

        Boolean leftTree= isSameTree(p.left, q.left);
        Boolean rightTree = isSameTree(p.right, q.right);
        return headTree && leftTree && rightTree;
    }
}
