package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class LC589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node cur;
        List<Node> children;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            result.add(cur.val);
            children = cur.children;
            if (children != null) {
                int childrenSize = children.size();
                for (int i = childrenSize - 1; i >= 0; i--) {
                    cur = children.get(i);
                    if (cur != null) {
                        stack.push(cur);
                    }
                }
            }
        }
        return result;
    }
}
