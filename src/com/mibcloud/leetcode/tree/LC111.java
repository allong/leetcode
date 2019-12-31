package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * 很多人写出的代码都不符合 【1,2 】这个测试用例，是因为没搞清楚题意
 *
 * 题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
 *
 * 题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
 *
 * 另外这道题的关键是搞清楚递归结束条件
 *
 * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
 * 当 root 节点左右孩子都为空时，返回 1
 * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
 * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
public class LC111 {
    //[1,2]和[1,2,null,3,null,4,null,5]的出错情况
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和右孩子其中一个为空，那么需要返回比较小的那个孩子的深度
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }
    /**代码可以进行简化，当左右孩子为空时 m1m1 和 m2m2 都为 00

     可以和情况 22 进行合并，即返回 m1+m2+1m1+m2+1*/
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1,m2) + 1;
    }
    public int minDepth3(TreeNode root) {//错误案例
        if (root == null) return 0;
        return Math.min(minDepth3(root.left), minDepth3(root.right)) + 1;
    }
    public int minDepth4(TreeNode root) {//官方答案
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
//    public int minDepth(TreeNode root) {
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        if (root == null) {
//            return 0;
//        }
//        else {
//            stack.add(new Pair(root, 1));
//        }
//
//        int current_depth = 0;
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> current = stack.poll();
//            root = current.getKey();
//            current_depth = current.getValue();
//            if ((root.left == null) && (root.right == null)) {
//                break;
//            }
//            if (root.left != null) {
//                stack.add(new Pair(root.left, current_depth + 1));
//            }
//            if (root.right != null) {
//                stack.add(new Pair(root.right, current_depth + 1));
//            }
//        }
//        return current_depth;
//    }
}
