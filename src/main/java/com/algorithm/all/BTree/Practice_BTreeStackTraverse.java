package com.algorithm.all.BTree;

import java.util.Stack;

/**
 * @ClassNamePractice_BTreePreTraverse
 * @Description 非递归方法遍历链表
 * @Author Yao Xin
 * @Date2020/9/25 13:55
 **/
public class Practice_BTreeStackTraverse {
    public static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 非递归方法先序遍历链表
     * 使用栈来记录节点，右节点先入栈，左节点再入
     * @param head
     */
    public static void preTraverse(Node head){
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.value);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    /**
     * 非递归方法后序遍历二叉树
     * @param head
     */
    public static void posTraverse(Node head){
        Stack<Node> stack = new Stack<>();
        Stack<Node> result = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            result.push(temp);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        while(!result.isEmpty()){
            System.out.println(result.pop().value);
        }
    }

    /**
     * 非递归方法中序遍历链表
     * 1）左节点不为空时统统入栈
     * 2）左节点为空，弹出栈顶打印，当前节点切换为右节点再进 1）步骤
     * @param head
     */
    public static void midTraverse(Node head){
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head != null){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else {
                Node pop = stack.pop();
                System.out.println(pop.value);
                head = pop.right;
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
        midTraverse(node1);

    }
}
