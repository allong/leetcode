package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中查找与目标数字最接近的节点
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 思路：如果当前节点值小于目标值，则结果只可能是当前节点值或者右子树中的值；
 * 如果当前节点值大于目标值，则结果只可能是当前节点值或者左子树中的值。
 */
public class LC270 {
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        double minGap = Double.MAX_VALUE;
        double curGap;
        int closestValue = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.val < target) {
                curGap = target - cur.val;
            } else if (cur.val > target) {
                curGap = cur.val - target;
            } else {
                return cur.val;
            }
            if (curGap < minGap) {
                minGap = curGap;
                closestValue = cur.val;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return closestValue;
    }
}
