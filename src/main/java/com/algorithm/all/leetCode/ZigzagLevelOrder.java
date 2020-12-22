package com.algorithm.all.leetCode;

import java.util.*;

/**
 * @ClassNameZigzagLevelOrder
 * @Description
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @Author Yao Xin
 * @Date2020/12/22 9:20
 **/
public class ZigzagLevelOrder {

/*    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList();
        Map<TreeNode,Integer> level = new HashMap<>();
        queue.add(root);
        level.put(root,0);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            Integer currLevel = level.get(poll);
            List<Integer> currRes;
            if(res.size()<=currLevel){
                currRes = new LinkedList<>();
                res.add(currRes);
            }else {
                currRes = res.get(currLevel);
            }
            currRes.add(poll.val);
            TreeNode left = poll.left;
            TreeNode right = poll.right;
            if(currLevel%2==0){
                if (left!=null) {
                    queue.add(left);
                    level.put(left,currLevel+1);
                }
                if (right!=null) {
                    queue.add(right);
                    level.put(right,currLevel+1);
                }
            }else {
                if (right!=null) {
                    queue.add(right);
                    level.put(right,currLevel+1);
                }
                if (left!=null) {
                    queue.add(left);
                    level.put(left,currLevel+1);
                }
            }
        }
        return res;
    }*/

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        recursion(root, res, 0);
        reverse(res);
        return res;
    }

    public static void reverse(List<List<Integer>> res){
        for(int i=0;i<res.size();i++){
            if(i%2!=0){
                List<Integer> integers = res.get(i);
                int left =0,right = integers.size()-1;
                while(right>left){
                    int temp = integers.get(right);
                    integers.set(right--,integers.get(left));
                    integers.set(left++,temp);
                }
            }
        }
    }

    public static void recursion(TreeNode node,List<List<Integer>> res,int i){
        if(node == null){
            return;
        }
        List<Integer> curr;
        if(res.size()<=i){
            curr = new LinkedList<>();
            res.add(curr);
        }else {
            curr = res.get(i);
        }
        curr.add(node.val);
        recursion(node.left,res,i+1);
        recursion(node.right,res,i+1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        System.out.println("aaa");
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
