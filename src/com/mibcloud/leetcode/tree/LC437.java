package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class LC437 {
    public int pathSum(TreeNode root, int sum) {
        int pathSum = 0;
        int curSum = 0;
        if (root != null) {
            curSum += root.val;
            if (curSum == sum) {
                pathSum++;
            }
            if (root.left != null) {

            }
            if (root.right != null) {

            }
        }
        return pathSum;
    }
    private void dfs(int curSum){

    }
}
