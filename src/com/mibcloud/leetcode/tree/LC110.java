package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树
 */
public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);//关键点
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
