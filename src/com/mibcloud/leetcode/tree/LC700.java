package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 */
public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.val == val) {
                return cur;
            } else if (cur.val < val) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    return null;
                }
            } else {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}
