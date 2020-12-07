package com.algorithm.all.leetCode;

/**
 * @ClassNameTreeNodes
 * @Description
 * 给出一个完全二叉树，求出该树的节点个数。
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * @Author Yao Xin
 * @Date2020/11/24 9:21
 **/
public class TreeNodes222 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        return recursion(root);
    }

    public int recursion(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+recursion(node.right)+recursion(node.left);
    }
}
