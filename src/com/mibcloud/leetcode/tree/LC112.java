package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 /**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有结点值相加等于目标和
 */
public class LC112 {
    //前序遍历，遇到叶子节点计算和
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.left == null && cur.right == null) {
                int curSum = 0;
                for (TreeNode node : stack) {
                    curSum += node.val;
                }
                if (curSum == sum) {
                    return true;
                }
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return false;
    }
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if ((root.left == null) && (root.right == null) && (sum == root.val)) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }

    }
}
