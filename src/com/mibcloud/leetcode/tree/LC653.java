package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.*;

/**两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。*/
public class LC653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (set.contains(k - cur.val)){
                return true;
            }
            set.add(cur.val);
            if (cur.right != null){
                queue.offer(cur.right);
            }
            if (cur.left != null){
                queue.offer(cur.left);
            }
        }
        return false;
    }
}
