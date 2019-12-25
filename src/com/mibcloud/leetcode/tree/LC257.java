package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class LC257 {
    //先序遍历
    // 如果当前节点的左儿子和右儿子都为None => 说明当前节点为一个根节点，输出一条路径
    // 如果当前节点有左儿子，带着path向左进行。如果有右儿子，带着path向右进行
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size;
            TreeNode cur;
            while (!queue.isEmpty()) {
                size = queue.size();
                String path = "";
                for (int i = 0; i < size; i++) {
                    cur = queue.poll();
                    if (cur.left == null && cur.right == null) {
                        result.add(path + "->" + cur.val);
                        continue;
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
        }
        return result;
    }

    //层序遍历
    // 如果当前节点的左儿子和右儿子都为None => 说明当前节点为一个根节点，输出一条路径
    // 如果当前节点有左儿子，带着path向左进行。如果有右儿子，带着path向右进行
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size;
            TreeNode cur;
            while (!queue.isEmpty()) {
                size = queue.size();
                String path = "";
                for (int i = 0; i < size; i++) {
                    cur = queue.poll();
                    if (cur.left == null && cur.right == null) {
                        result.add(path + "->" + cur.val);
                        continue;
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
        }
        return result;
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root != null){
            dfs(result, root, "" + root.val);
        }
        return result;
    }

    private void dfs(List<String> result, TreeNode root, String path) {//带path往下一层传递
        if (root != null) {
            if (root.left == null && root.right == null) {
                result.add(path);
                return;
            }
            if (root.left != null) {
                dfs(result, root.left, path + "->" + root.left.val);
            }
            if (root.right != null) {
                dfs(result, root.right, path + "->" + root.right.val);
            }
        }
    }
}
