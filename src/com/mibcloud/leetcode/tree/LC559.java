package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.Node;

import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class LC559 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        if (children == null || children.size() == 0) return 1;
        Node child;
        int childDepth = 0;
        for (int i = 0; i < children.size(); i++) {
            child = children.get(i);
            if (child != null) {
                childDepth = Math.max(maxDepth(child) + 1, childDepth);
            }
        }
        return childDepth;
    }
}
