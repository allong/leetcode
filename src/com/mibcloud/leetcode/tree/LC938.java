package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 */
public class LC938 {
    //中序遍历能提高效率
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;

            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.val >= L && node.val <= R) {
                    sum += node.val;
                }
                if (node.val <= R) {
                    if (node.right != null) {
                        cur = node.right;
                    }
                } else {
                    break;
                }
            }
        }
        return sum;
    }

}
