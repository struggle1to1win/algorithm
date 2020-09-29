package com.algorithm.all;

/**
 * @ClassNamePractice_BTreeIsFull
 * @Description
 * @Author Yao Xin
 * @Date2020/9/29 15:34
 **/
public class Practice_BTreeIsFull {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info{
        private int num;
        private boolean isFull;
        private int height;
    }

    public static Info isFull(Node node){
        if(node==null){
            return null;
        }
        Info left = isFull(node.left);
        Info right = isFull(node.right);
        return null;
    }
}
