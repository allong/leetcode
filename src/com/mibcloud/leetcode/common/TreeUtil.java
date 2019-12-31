package com.mibcloud.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    /**
     * 层序建立二叉树
     *
     * @param input [-10,-3,0,5,null,9]
     */
    public static TreeNode create(String input) {
        if (input == null) return null;
        int len = input.length();
        if (len < 2) return null;
        if (!input.startsWith("[") || !input.endsWith("]")) return null;
        String[] nums = input.substring(1, len - 1).split(",");
        return create(nums);
    }

    /**
     * 层序建立二叉树
     */
    public static TreeNode create(String[] nums) {
        if (nums == null || nums.length == 0) return null;
        String node1 = nums[0];
        if (node1 == null || "null".equals(node1)) {
            return null;
        }
        int first = Integer.parseInt(node1);
        TreeNode root = new TreeNode(first);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curIndex = 0;
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            ++curIndex;
            if (curIndex >= nums.length) {
                break;
            }
            String left = nums[curIndex];
            if (left == null || "null".equals(left)) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(Integer.parseInt(left));
                queue.offer(cur.left);
            }
            ++curIndex;
            if (curIndex >= nums.length) {
                break;
            }
            String right = nums[curIndex];
            if (right == null || "null".equals(right)) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(Integer.parseInt(right));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
