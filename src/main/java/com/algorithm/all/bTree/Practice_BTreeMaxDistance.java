package com.algorithm.all.bTree;

/**
 * @ClassNamePractice_BTreeMaxDistance
 * @Description
 * @Author Yao Xin
 * @Date2020/9/28 10:41
 **/
public class Practice_BTreeMaxDistance {

    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Info{
        private int height;
        private int maxDistance;

        public Info(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static Info findMaxDistance(Node node){
        if(node==null){
            return new Info(0,0);
        }
        Info left = findMaxDistance(node.left);
        Info right = findMaxDistance(node.right);
        int max = Math.max(left.maxDistance,right.maxDistance);
        max = Math.max(max,left.height+right.height+1);
        return new Info(Math.max(left.height,right.height)+1,max);
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
//        node2.right = node5;
        node3.left = node6;
        node6.left = node4;
        node3.right = node7;
        node7.right = new Node(11);

        Info maxDistance = findMaxDistance(node1);
        System.out.println(maxDistance.height+" "+maxDistance.maxDistance);
    }
}
