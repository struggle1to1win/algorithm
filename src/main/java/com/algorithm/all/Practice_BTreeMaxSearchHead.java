package com.algorithm.all;

/**
 * @ClassNamePractice_BTreeMaxSearchHead
 * @Description
 * @Author Yao Xin
 * @Date2020/9/29 9:17
 **/
public class Practice_BTreeMaxSearchHead {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info{
        private Node head;
        private boolean isBST;
        private int max;
        private int min;
        private int height;

        public Info(Node head, boolean isBST, int max, int min, int height) {
            this.head = head;
            this.isBST = isBST;
            this.max = max;
            this.min = min;
            this.height = height;
        }
    }

    public static Info findMaxSearchHead(Node node){
        if(node == null){
            return null;
        }
        Info left = findMaxSearchHead(node.left);
        Info right = findMaxSearchHead(node.right);
        int max = node.value;
        int min = node.value;
        if(left!=null){
            max = Math.max(max,left.max);
            min = Math.min(min,left.min);
        }
        if(right!=null){
            max = Math.max(max,right.max);
            min = Math.min(min,right.min);
        }
        boolean isBST =
                (left==null&&right==null)
                ||(left==null||right==null?(left==null?true:left.isBST&&right==null?true:right.isBST):false)
                ||(left.isBST&&right.isBST&&(node.value>left.max&&node.value<right.min));

        Node head;
        int height;
        if (isBST||(left==null&&right==null)){
            head = node;
            height = Math.max(left==null?0:left.height,right==null?0:right.height)+1;
        }else if(left==null||right==null){
            head = left==null?right.head:left.head;
            height = (left==null?right.height:left.height)+1;
        }else if(left.isBST&&right.isBST){
            head = left.height>right.height?left.head:right.head;
            height = left.height>right.height?left.height:right.height;
        }else if(left.isBST){
            head = left.head;
            height = left.height;
        }else {
            head = right.head;
            height = right.height;
        }
        return new Info(head,isBST,max,min,height);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
//        node1.left = node2;
        node1.right = node3;
//        node2.right = node5;
//        node3.left = node6;
        node6.left = node4;
        node3.right = node7;
        node7.right = new Node(11);
        Info maxSearchHead = findMaxSearchHead(node1);
        System.out.println("headValue:"+maxSearchHead.head.value+" height:"+maxSearchHead.height
                +" max:"+maxSearchHead.max+" min:"+maxSearchHead.min);
    }
}
