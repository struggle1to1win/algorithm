package com.algorithm.all;

import java.util.Stack;

/**
 * @ClassNamePractice_Plalindrome
 * @Description 判断一个单链表是否为回文串
 * @Author Yao Xin
 * @Date2020/9/24 11:07
 **/
public class Practice_Plalindrome {
    public static class Node{
        private char value;
        private Node next;

        public Node(char value) {
            this.value = value;
        }
    }

    //使用一个栈来处理
    public static boolean isPlalindrome(Node head){
        Stack<Character> stack = new Stack<>();
        Node node = head;
        while(node!=null){
            stack.push(node.value);
            node = node.next;
        }
        node = head;
        while (node!=null) {
            if(node.value!=stack.pop())return false;
            node = node.next;
        }
        return true;
    }

    //反转中点之后的节点来实现
    public static boolean isPlalindromeBest(Node head){
        Node midNode = findMidNode(head);
        Node reversHead = revers(midNode);
        while(head!=null&&reversHead!=null){
            if(head.value!=reversHead.value){
                return false;
            }
            head = head.next;
            reversHead = reversHead.next;
        }
        return true;
    }

    public static Node revers(Node head){
        if(head==null) return head;
        Node pre = null;
        while(head!=null){
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node findMidNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node('a');
        Node node1 = new Node('b');
        Node node2 = new Node('c');
        Node node3 = new Node('b');
        Node node4 = new Node('a');

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(isPlalindromeBest(head));
    }
}
