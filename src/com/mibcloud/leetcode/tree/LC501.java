package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.*;

/**
 * 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 */
public class LC501 {
    //二叉搜索树与中序遍历有隐含关系
    public int[] findMode(TreeNode root) {
        int[] result = {};
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (map.containsKey(cur.val)) {
                map.put(cur.val, map.get(cur.val) + 1);
            } else {
                map.put(cur.val, 1);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    public int[] findMode1(TreeNode root) {
        int[] result = {};
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (map.containsKey(cur.val)) {
                map.put(cur.val, map.get(cur.val) + 1);
            } else {
                map.put(cur.val, 1);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        //后续步骤将map排序，然后取最大
        int maxCount = 0;
        Set<Integer> maxCountSet = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();

            }
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        return result;
    }
}
