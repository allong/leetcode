package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 左叶子之和
 */
public class LC404 {
    //前序遍历，某节点cur.left != null && cur.left.left == null && cur.left.right == null
    //只有一个跟结点算不算叶结点
    // 输入[1] 预期结果0
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
//        if (root.left == null && root.right == null) return root.val;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.left != null && cur.left.left == null && cur.left.right == null) {
                sum += cur.left.val;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return sum;
    }
}
