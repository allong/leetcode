package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.Stack;

/**如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。*/
public class LC965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        int value = root.val;
        while (!stack.isEmpty()){
            cur = stack.pop();
            if (cur.val != value){
                return false;
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }

        }
        return true;
    }
}
