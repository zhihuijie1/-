package Novice_class;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 二叉树的层序遍历 II

public class BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            List<List<Integer>> lists = new LinkedList<>();
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // list存放结果
        List<List<Integer>> list = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // 记录每一层的节点个数
            int size = queue.size();
            // 记录当前这一层的节点
            List<Integer> listone = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 有左先加左，有右后加右
                if(cur.left != null) {
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                listone.add(cur.val);
            }
            // 头插法
            list.add(0,listone);
        }
        return list;
    }
}
