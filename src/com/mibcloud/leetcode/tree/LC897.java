package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 */
public class LC897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        LinkedList<Integer> list = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                cur = node.right;
            }
        }
        if (list.isEmpty()) return null;
        TreeNode result = new TreeNode(list.get(0));
        TreeNode newCur = result;
        for (int i = 1; i < list.size(); i++) {
            newCur.right = new TreeNode(list.get(i));
            newCur = newCur.right;
        }
        return result;
    }
    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode newCur = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (newCur != null) {//之所以超时，因为没有断开原树中的链接
                    newCur.right = node;
                    newCur = newCur.right;
                } else {
                    newRoot = node;
                    newCur = newRoot;
                }
                cur = node.right;
            }
        }
        return newRoot;

    }
}
