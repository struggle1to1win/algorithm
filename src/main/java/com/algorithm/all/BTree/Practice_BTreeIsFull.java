package com.algorithm.all.BTree;

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

        public Info(int num, boolean isFull, int height) {
            this.num = num;
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static Info isFull(Node node){
        if(node==null){
            return null;
        }
        Info left = isFull(node.left);
        Info right = isFull(node.right);

        if(left==null&&right==null){
            return new Info(1,true,1);
        }else if(left==null||right==null){
            return new Info(0,false,0);
        }else {
            boolean isFull = left.isFull&&right.isFull
                            &&left.height==right.height;
            int height = Math.max(left.height,right.height)+1;
            return new Info(0,isFull,height);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node2.left = node4;
        node3.left = node6;
        node3.right = node7;
        //node7.right = new Node(11);

        Info full = isFull(node1);
        System.out.println("isFull:"+full.isFull+" height:"+full.height);
    }
}
