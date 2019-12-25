package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Medium
 * <p>
 * 985
 * <p>
 * 36
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * Return:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class LC113 {
    /**
     * 两种写法，从sum的角度去看，可以从sum减，也可以从0加到sum。
     * 每次先将当前节点加入中间集合(path)，然后深度优先遍历；
     * 遍历完记得回溯的时候要在path集合中移除当前节点；
     * 注意递归条件哪里一定不要return；
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }


}
