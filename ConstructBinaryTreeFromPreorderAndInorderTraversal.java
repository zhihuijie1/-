package Novice_class;

import java.util.HashMap;

// 从前序与中序遍历序列构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return f(preorder,0, preorder.length-1, inorder,0,inorder.length-1,hashMap);
    }

    // 有一棵树，先序结果是pre[L1...R1]，中序结果是in[L2...R2]
    // 请你建出这棵树
    public TreeNode f(int[] pre, int L1, int R1, int[] in, int L2, int R2,HashMap<Integer,Integer> hashMap) {
        if(pre == null || in == null || pre.length != in.length) {
            return null;
        }

        if(L1 == R1) {
            return new TreeNode(pre[L1]);
        }
        if(L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        // 找到中序遍历中头节点的位置
        int find = hashMap.get(pre[L1]);
        head.left = f(pre,L1 + 1, L1 + find - L2, in, L2, find - 1, hashMap);
        head.right = f(pre, L1 + find - L2 + 1, R1, in, find + 1, R2, hashMap);
        return head;
    }

    // 打印二叉树的函数
    public static void printTree(TreeNode head) {
        System.out.println("打印二叉树，看的时候请把图像顺指针转90度:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    // 打印二叉树的函数
    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    // 打印二叉树的函数
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
