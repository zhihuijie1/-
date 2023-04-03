package Novice_class;

// 平衡二叉树
public class BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    // 以当前节点为头节点的树是否是平衡树 返回两个结果 1：Boolean类型的是否是平衡树 2：这棵树的高度
    public static Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftTree = process(root.left);
        Info rightTree = process(root.right);
        boolean B = ((Math.abs(leftTree.height - rightTree.height) <= 1) && leftTree.isBalanced && rightTree.isBalanced) ? true : false;
        int H = Math.max(leftTree.height, rightTree.height) + 1;
        return new Info(B, H);
    }
}
