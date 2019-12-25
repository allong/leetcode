package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 对称的二叉树
 */
public class LC101 {
    //判断二叉树是否是平衡树，比如有两个节点n1, n2，我们需要比较n1的左子节点的值和n2的右子节点的值是否相等，
    //同时还要比较n1的右子节点的值和n2的左子结点的值是否相等，以此类推比较完所有的左右两个节点。
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode n1, TreeNode n2) {
        if (n1 == n2) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }

    //循环
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root.left);
        queue.offer(root.right);
        TreeNode left, right;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            left = stack.pop();
            right = queue.poll();
            if (left == right) {
                continue;
            }
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            stack.push(left.left);
            stack.push(left.right);
            queue.offer(right.left);
            queue.offer(right.right);
        }
        return true;
    }

    //中序或者
    // 层序遍历:入队顺序依次是:左子树的左儿子,右子树的右儿子,左子树的右儿子,右子树左儿子。队列中每两个元素相等，出队的时候两两检查是不是对称。
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        TreeNode left, right;
        while (!queue.isEmpty()) {
            left = queue.poll();
            right = queue.poll();
            if (left == right) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
