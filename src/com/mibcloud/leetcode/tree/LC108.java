package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 数组长度为偶数时，选中间左边和中间右边的都可以。数组长度为奇数时，选中间结点。
 */
public class LC108 {

    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] nums, int start, int end) {
        if (start > end) return null;
        System.out.println("start=" + start + ",end=" + end);

        if (start == end) return new TreeNode(nums[start]);
        int mid = end - (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, start, mid - 1);
        root.right = create(nums, mid + 1, end);
        return root;

    }

    private TreeNode create1(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start < end) {
            int mid = start + (end - start) / 2;//错误点
            TreeNode root = new TreeNode(nums[mid]);
            root.left = create1(nums, start, mid - 1);
            root.right = create1(nums, mid + 1, end);
            return root;
        }
        return null;
    }
}
