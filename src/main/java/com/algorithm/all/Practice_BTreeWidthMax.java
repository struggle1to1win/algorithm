package com.algorithm.all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassNamePractice_BTreeWidthMax
 * @Description
 * @Author Yao Xin
 * @Date2020/9/27 10:34
 **/
public class Practice_BTreeWidthMax {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int findMaxWidth(Node head){
        int max=0;
        Map<Node,Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        map.put(head,1);
        int currLevel = 1;
        int currNodes = 0;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.left!=null){
                queue.add(poll.left);
                map.put(poll.left,map.get(poll)+1);
            }
            if(poll.right!=null){
                queue.add(poll.right);
                map.put(poll.right,map.get(poll)+1);
            }
            if(currLevel == map.get(poll)){
                currNodes++;
            }else {
                max = Math.max(currNodes,max);
                currLevel++;
                currNodes=1;
            }
        }

        return Math.max(max,currNodes);
    }

    public static int findMaxWithNoMap(Node head){
        Queue<Node> queue = new LinkedList<>();
        Node currEnd = head;
        queue.add(currEnd);
        Node nextEnd = null;
        int max = 0;
        int levelNodes = 0;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.left!=null){
                queue.add(poll.left);
                nextEnd = poll.left;
            }
            if(poll.right!=null){
                queue.add(poll.right);
                nextEnd = poll.right;
            }
            levelNodes++;
            if(currEnd == poll){
                currEnd = nextEnd;
                max = Math.max(max,levelNodes);
                levelNodes = 0;
            }
        }
        return max;
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
        node7.right = new Node(8);

        System.out.println(findMaxWithNoMap(node1));
    }
}
