package com.algorithm.all;

/**
 * @ClassNamePractice_findIntersectNode
 * @Description
 * @Author Yao Xin
 * @Date2020/9/24 16:35
 **/
public class Practice_FindIntersectNode {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //快慢指针找入环节点
    public static Node findLoopNode(Node head){
        if (head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while(fast!=null){
            if (slow==fast){
                fast=head;
                while(fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    //两链表都无环时找相交节点
    public static Node bothNoLoop(Node head1,Node head2){
        return null;
    }

    public static Node findIntersectNode(Node head1,Node head2){
        Node loopNode1 = findLoopNode(head1);
        Node loopNode2 = findLoopNode(head2);
        if((loopNode1==null||loopNode2==null)&&(loopNode1!=null&&loopNode2!=null)){return null;}

        if (loopNode1==null&&loopNode2==null){}
        return null;
    }
}
