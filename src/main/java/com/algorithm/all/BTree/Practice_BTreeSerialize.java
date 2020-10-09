package com.algorithm.all.BTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassNamePractice_BTreeSerialize
 * @Description
 * @Author Yao Xin
 * @Date2020/9/27 11:10
 **/
public class Practice_BTreeSerialize {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Queue<String> serializeBTree(Node head){
        Queue<String> ser = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        ser.add(String.valueOf(head.value));
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.left!=null){
                queue.add(poll.left);
                ser.add(String.valueOf(poll.left.value));
            }else {
                ser.add(null);
            }

            if(poll.right!=null){
                queue.add(poll.right);
                ser.add(String.valueOf(poll.right.value));
            }else {
                ser.add(null);
            }
        }
        return ser;
    }

    public static Node rebuildBTree(Queue<String> queue){
        Node head = getNode(queue.poll());
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(head);
        while (!myQueue.isEmpty()){
            Node poll = myQueue.poll();
            poll.left = getNode(queue.poll());
            poll.right = getNode(queue.poll());
            if(poll.left!=null){
                myQueue.add(poll.left);
            }
            if(poll.right!=null){
                myQueue.add(poll.right);
            }
        }
        return head;
    }

    public static Node getNode(String str){
        return str==null?null:new Node(Integer.valueOf(str));
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
        node3.right = node7;
        node7.right = new Node(11);

        Queue<String> queue = serializeBTree(node1);
        //System.out.println(queue);
        Node node = rebuildBTree(queue);
        System.out.println(1);
    }
}
