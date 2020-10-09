package com.algorithm.all.bTree;

/**
 * @ClassNamePractice_BTreeFindNextNode
 * @Description 找到节点的后继节点
 * 后继节点：中序遍历时的下一个节点
 * 如果一个节点有右节点，右节点就是他的后继节点
 * 没有右节点的话，向上找父节点，如果当前节点是父节点的左节点，父节点便是后继节点
 * @Author Yao Xin
 * @Date2020/9/28 9:06
 **/
public class Practice_BTreeFindNextNode {
    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node findNextNode(Node node){
        if(node.right!=null){
            return node.right;
        }
        Node parentNode = node.parent;
        while(parentNode.left!=node){
            node = parentNode;
            parentNode = node.parent;
        }
        return parentNode;
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
        node2.parent = node1;
        node3.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;

        System.out.println(findNextNode(node3).value);
        System.out.println(findNextNode(node2).value);
        System.out.println(findNextNode(node5).value);
    }
}
