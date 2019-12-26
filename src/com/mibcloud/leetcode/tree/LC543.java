package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

/**
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 注意：两结点之间的路径长度是以它们之间[边的数目]表示。
 */
public class LC543 {
    //这一题就是找到每个节点的深度=max(左节点深度,右节点深度)+1。
    //直径=节点左子树的深度+右子树的深度。因此只需要计算出每个节点深度，就可以得到穿过某节点的直径。
    //因此得到深度之后可以选择利用dfs深度优先搜索来找到答案，也可以在求深度的时候
    //就直接计算，然后保存在hashmap中。
    //注：最长直径未必穿越根结点。
    //注：不但要求每个结点的深度，还要求每个结点左右子树的深度和。
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if (leftDepth + rightDepth > maxDiameter) {
            maxDiameter = leftDepth + rightDepth;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
