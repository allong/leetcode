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
    //[1,null,2] - > [2,1]
    public int[] findMode(TreeNode root) {
        int[] result = {};
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                //第一个弹出的结点一定是在所有left都入stack后的栈顶元素，
                //该结点即是上一个结点的left，又是无left的root
                TreeNode node = stack.pop();
                if (map.containsKey(node.val)) {
                    map.put(node.val, map.get(node.val) + 1);
                } else {
                    map.put(node.val, 1);
                }
                if (node.right != null) {
                    cur = node.right;
                }
            }
        }
        int maxCount = 0;
        List<Integer> maxKeyList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxKeyList.clear();
                maxCount = entry.getValue();
                maxKeyList.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                maxKeyList.add(entry.getKey());
            }
        }
        if (!maxKeyList.isEmpty()){
            result = new int[maxKeyList.size()];
            for (int i = 0; i < maxKeyList.size(); i++) {
                result[i] = maxKeyList.get(i);
            }
        }
        return result;
    }
}
