package Novice_class;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(root, sum, 0, path, ans);
        return ans;
    }

    // 左子树中有没有这个路径，右子树中有没有这个路径
    public static void process(TreeNode x, int sum, int preSum, List<Integer> path, List<List<Integer>> ans) {
        if (x == null) {
            return;
        }
        // 来到叶子节点
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                path.add(x.val);
                // 返回一个新的地址
                ans.add(copyList(path));
                path.remove(path.size() - 1);
            }
            return;
        }

        preSum = preSum + x.val;
        path.add(x.val);
        process(x.left, sum, preSum, path, ans);
        process(x.right, sum, preSum, path, ans);
        path.remove(path.size() - 1);
        return;
    }

    public static List<Integer> copyList(List<Integer> path) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            cur.add(i, path.get(i));
        }
        return cur;
    }
}


