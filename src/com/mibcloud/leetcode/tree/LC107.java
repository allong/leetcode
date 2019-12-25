package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LC107 {
    //使用curCnt和nextCnt追踪每层的节点个数
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int curCnt = 1;//当前层节点数
            int nextCnt = 0;//下一层节点数,初始未知
            TreeNode cur;
            List<Integer> levelList = new LinkedList<>();
            while (!queue.isEmpty()) {
                cur = queue.poll();
                curCnt--;
                levelList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                    nextCnt++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    nextCnt++;
                }
                if (curCnt == 0) {//当前层完毕
//                    result.add(levelList);
                    result.add(0, levelList);//达到逆序效果
                    curCnt = nextCnt;//下层成为当前层
                    nextCnt = 0;//重置下层节点数
                    levelList = new LinkedList<>();
                }
            }

        }
        return result;
    }

    //
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode cur;
            List<Integer> levelList;
            while (!queue.isEmpty()) {
                levelList = new LinkedList<>();
                int curSize = queue.size();//首先得到当前队列大小，不统计后续添加的结点，因为后续添加的结点都是下一层的
                for (int i = 0; i < curSize; i++) {
                    cur = queue.poll();//只能poll出上次循环中添加的结点
                    levelList.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                result.add(0, levelList);
            }

        }
        return result;
    }
}
