package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LC111 {
    //[1,2]和[1,2,null,3,null,4,null,5]的出错情况
    public TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        root.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;
        return root;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        int minDepth = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                cur = queue.poll();
                if (cur.left == null || cur.right == null) {
                    return minDepth;
                } else {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
    }
}
