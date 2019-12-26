package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
public class LC572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.val == t.val) {
                if (isSame(cur, t)) {
                    return true;
                }
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return false;
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == t) return true;
        if (t == null || s == null) return false;
        if (s.val == t.val) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return false;
    }
}
