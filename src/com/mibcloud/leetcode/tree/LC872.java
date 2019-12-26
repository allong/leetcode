package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 */
public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        TreeNode cur1, cur2;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                cur1 = stack1.pop();
                if (cur1.left == null && cur1.right == null) {
                    list1.add(cur1.val);
                }
                if (cur1.right != null) {
                    stack1.push(cur1.right);
                }
                if (cur1.left != null) {
                    stack1.push(cur1.left);
                }
            }
            if (!stack2.isEmpty()) {
                cur2 = stack2.pop();
                if (cur2.left == null && cur2.right == null) {
                    list2.add(cur2.val);
                }
                if (cur2.right != null) {
                    stack2.push(cur2.right);
                }
                if (cur2.left != null) {
                    stack2.push(cur2.left);
                }
            }
            int len = list1.size();
            if (len > 0 && len == list2.size()) {
                for (int i = len - 1; i >= 0; i--) {
                    if (list1.get(i) != list2.get(i)) {
                        return false;
                    }
                }
            }

        }

        if (list1.size() != list2.size()) return false;
        return true;
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        List<Integer> list = new LinkedList<>();
        TreeNode cur;
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            if (cur.left == null && cur.right == null) {
                list.add(cur.val);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            if (cur.left != null) {
                stack1.push(cur.left);
            }
        }
        int len = list.size();
        int index = 0;
        while (!stack2.isEmpty()) {
            cur = stack2.pop();
            if (cur.left == null && cur.right == null) {
                if (index >= len) {
                    return false;
                }
                if (list.get(index) != cur.val) {
                    return false;
                }
                index++;
            }
            if (cur.right != null) {
                stack2.push(cur.right);
            }
            if (cur.left != null) {
                stack2.push(cur.left);
            }
        }
        return true;
    }

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        TreeNode cur;
        while (!stack1.isEmpty()) {
            cur = stack1.pop();
            if (cur.left == null && cur.right == null) {
                sb1.append(cur.val).append(",");
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            if (cur.left != null) {
                stack1.push(cur.left);
            }
        }
        while (!stack2.isEmpty()) {
            cur = stack2.pop();
            if (cur.left == null && cur.right == null) {
                sb2.append(cur.val).append(",");
            }
            if (cur.right != null) {
                stack2.push(cur.right);
            }
            if (cur.left != null) {
                stack2.push(cur.left);
            }
        }
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        return s1 == s2 || s1.equals(s2);
    }
}
