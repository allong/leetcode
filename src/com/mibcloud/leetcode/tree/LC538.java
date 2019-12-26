package com.mibcloud.leetcode.tree;

import com.mibcloud.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * 把二叉搜索树转换为累加树
 */
public class LC538 {
    //因为是平衡二叉树，所以右边的节点的值是大于左边的值。
    //这个题的动机是我们应该先修改数值比较大的节点，然后修改数值比较小的节点。(逆中序遍历)
    // 这样做，才能保证，我们只需要一次遍历，就把每个节点的值修改成了比它值更大的所有节点的和。
    //BST的右子树都比该节点大，所以修改次序是右–>中–>左。
    // 用一个变量储存遍历过程中所有有节点之和就得到了所有的比当前把该节点的值更大的和，然后修改为该变量的值即可。
    int sum = 0;//已扫描结点的总和

    public TreeNode convertBST1(TreeNode root) {
        convert(root);
        return root;
    }

    private void convert(TreeNode node) {
        if (node == null) return;
        //1. 取右侧所有结点的总和
        convert(node.right);
        //2. 取当前结点+右侧所有结点的总和,（假设1和3都为空，2便是核心步骤)
        node.val += sum;
        sum = node.val;
        //3. 取左侧所有结点的总和
        convert(node.left);
    }

    //循环获取逆中序序列，然后从前向后累加
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.addFirst(cur);
                cur = cur.right;
            }
        }
        ListIterator<TreeNode> it = list.listIterator();
        int sum = 0;
        TreeNode node;
        while (it.hasNext()) {
            node = it.next();
            node.val += sum;
            sum = node.val;
        }
        return root;
    }
}
