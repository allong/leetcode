package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历
 */
public class LC94 {
    /*1.以root-left-right三个节点为单位，递归找left节点
     * 2.找到最后一定是null-root-right
     * 3.此时栈顶就是当前的root，出栈并访问root（left为null，满足left-root的顺序）
     * 4.当前root的right进栈，满足root-right
     * 5.以right为root递归left-root-right
     * 总体思路：left不为空则递归找left，left为空则出栈，然后切换到right继续递归root-right,此时不能再处理left了，否则会导致死循环*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;

        }
        return result;
    }
}
