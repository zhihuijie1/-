package Novice_class;

// 路径总和
public class PathSum {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 返回左子树有没有总和 == targetSum - root.val
    //  返回右子树有没有总和 == targetSum - root.val
    public static Boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 叶节点
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        Boolean leftTree = hasPathSum(root.left, targetSum - root.val);
        Boolean rightTree = hasPathSum(root.right, targetSum - root.val);
        if (leftTree || rightTree) {
            return true;
        }
        return false;
    }
}

