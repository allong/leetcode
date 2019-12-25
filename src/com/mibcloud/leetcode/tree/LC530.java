package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树的最小绝对差
 * 题目描述：
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * <p>
 * 题目分析：根据二叉搜索树的性质可得，按中序遍历，即可得到一个递增的序列，
 * 所以问题转换为，对于一个递增的序列，求相邻元素的最小绝对差。
 */
public class LC530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        List<Integer> list = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                cur = cur.left;
                if (cur != null) {
                    stack.push(cur);
                }
            }
            if (!stack.isEmpty()) {
                TreeNode topNode = stack.pop();
                list.add(topNode.val);
                if (topNode.right != null) {
                    stack.push(topNode.right);
                    cur = topNode.right;
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        int curDiff;
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            curDiff = Math.abs(list.get(i) - list.get(i - 1));
            if (curDiff < diff) {
                diff = curDiff;
            }
        }
        return diff;
    }
}
