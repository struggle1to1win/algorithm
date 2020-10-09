package com.algorithm.all.BTree;

/**
 * @ClassNamePractice_BTreeTraverse
 * @Description 使用递归序遍历二叉树
 * @Author Yao Xin
 * @Date2020/9/25 11:39
 **/
public class Practice_BTreeTraverse {
    public static class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void preTraverse(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.value);
        preTraverse(head.left);
        preTraverse(head.right);
    }

    public static void midTraverse(Node head){
        if(head==null){
            return;
        }
        midTraverse(head.left);
        System.out.println(head.value);
        midTraverse(head.right);
    }

    public static void postTraverse(Node head){
        if(head==null){
            return;
        }
        postTraverse(head.left);
        postTraverse(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.left = new Node(2);
        node1.right = new Node(3);
        node1.left.left = new Node(4);
        node1.left.right = new Node(5);
        node1.right.left = new Node(6);
        node1.right.right = new Node(7);

        postTraverse(node1);
    }
}
