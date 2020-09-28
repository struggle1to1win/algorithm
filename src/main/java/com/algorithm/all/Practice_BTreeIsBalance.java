package com.algorithm.all;

/**
 * @ClassNamePractice_BTreeIsBalance
 * @Description
 * @Author Yao Xin
 * @Date2020/9/28 9:29
 **/
public class Practice_BTreeIsBalance {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info{
        private boolean isBalance;
        private int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }


    }

    public static Info isBalance(Node node){
        if(node==null){
            return new Info(true,0);
        }
        Info left = isBalance(node.left);
        Info right = isBalance(node.right);
        int height = Math.max(left.height,right.height)+1;
        boolean isBalance = left.isBalance&&right.isBalance&&(Math.abs(left.height-right.height)<=1);
        return new Info(isBalance,height);
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
        node3.left = node6;
        node3.right = node7;
        node7.right = new Node(11);

        Info balance = isBalance(node1);
        System.out.println(balance.isBalance+" "+balance.height);
    }
}
