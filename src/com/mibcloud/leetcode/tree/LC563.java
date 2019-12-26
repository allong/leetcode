package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。(上限32位整数)
 * <p>
 * 一个树的节点的坡度定义为：该节点左子树的结点之和-右子树结点之和的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 */
public class LC563 {
    //    分析：
//        1.坡度为每个节点的“左子树结点的和”-“右子树结点的和”的绝对值
//        2.总坡度为各节点坡度和相加
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int sumTilt = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            int sumLeft = sum(cur.left);
            int sumRight = sum(cur.right);
            sumTilt += Math.abs(sumLeft - sumRight);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return sumTilt;
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }
}
