package com.algorithm.all;

/**
 * @ClassNamePractice_FastSlowPointer
 * @Description  快慢指针找链表中点，奇数偶数节点不同情况。可以通过快慢指针初始节点及循环条件来控制
 * @Author Yao Xin
 * @Date2020/9/24 9:09
 **/
public class Practice_FastSlowPointer {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node midAndLastNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
//        Node node7 = new Node(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node7;
        System.out.println(midAndLastNode(head).value);
    }
}
