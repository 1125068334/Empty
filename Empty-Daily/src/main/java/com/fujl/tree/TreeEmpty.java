package com.fujl.tree;

import java.util.LinkedList;

public class TreeEmpty {

    public static TreeNode root;

    /**
     *       1
     *    2    3
     *      4
     *     5
     */
    static {
        root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(5);
    }

    public static void main(String[] args) throws InterruptedException {
//        inorderTraversalRecursive(root);
        binaryTreeLevelOrder(root);
    }

    // Time: O(n). Space: O(n)
    public static void inorderTraversalRecursive(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode left = root.left;
        if (null != left) {
            inorderTraversalRecursive(left);
        }
        int val = root.val;
        System.out.println(val);
        TreeNode right = root.right;
        if (null != right) {
            inorderTraversalRecursive(right);
        }
        return;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    /**
     * 二叉树层级遍历
     */
    public static void binaryTreeLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempRoot = queue.poll();
            System.out.println(tempRoot.val);
            if (null != tempRoot.left) {
                queue.add(tempRoot.left);
            }
            if (null != tempRoot.right) {
                queue.add(tempRoot.right);
            }
        }
    }
}