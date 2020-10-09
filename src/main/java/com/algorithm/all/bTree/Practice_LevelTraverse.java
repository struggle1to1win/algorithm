package com.algorithm.all.bTree;

import java.util.LinkedList;

/**
 * @ClassNamePractice_LevelTraverse
 * @Description 宽度优先遍历
 * @Author Yao Xin
 * @Date2020/9/25 16:59
 **/
public class Practice_LevelTraverse {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void levelTraverse(Node head){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.value);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
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
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        //preTraverse(node1);
        System.out.println("=================================");
        levelTraverse(node1);
    }
}
