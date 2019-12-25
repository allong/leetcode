package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class LC226 {
    //递归左右交换
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invert(root.left);
            invert(root.right);
        }
    }

    //层序遍历左右交换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
