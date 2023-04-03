package Novice_class;

// 验证二叉搜索树
public class IsBinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    // 左子树都是二叉搜索树，并且左子树中最大的数小于当前节点
    // 右子树都是二叉搜索树，并且右子树中最小的数大于当前节点，
    public static Info process(TreeNode x) {
        if (x == null) {
            return null;
        }
        Info leftTree = process(x.left);
        Info rightTree = process(x.right);
        boolean leftB = (leftTree != null) ? leftTree.max < x.val : true;
        boolean rightB = (rightTree != null) ? rightTree.min > x.val : true;
        boolean isBST = (leftTree == null || leftTree.isBST) && (rightTree == null || rightTree.isBST) && leftB && rightB;
        int max = x.val;
        int min = x.val;
        if (leftTree != null) {
            max = Math.max(leftTree.max, x.val);
            min = Math.min(leftTree.min, x.val);
        }
        if (rightTree != null) {
            max = Math.max(rightTree.max, max);
            min = Math.min(rightTree.min, min);
        }
        return new Info(isBST, max, min);
    }
}
