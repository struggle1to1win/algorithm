package com.algorithm.all;

/**
 * @ClassNamePractice_findIntersectNode
 * @Description  给定两个链表，这两链表可能有环可能无环，问它两是否相交，相交返回第一个相交节点
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
        while(fast!=null&&fast.next!=null){
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
    //思想：两链表相交部分必然等长
    //操作：算两链表的长度，长链表先走多余长度，使两链表等长，再同时走，直到相等
    public static Node bothNoLoop(Node head1,Node head2){
        Node temp1 = head1;
        int size1 = 0;
        Node temp2 = head2;
        int size2 = 0;
        while(temp1!=null){
            size1++;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            size2++;
            temp2 = temp2.next;
        }
        Node temp = size1-size2>0?head1:head2;
        int n = size1-size2;
        while(n!=0){
            temp = temp.next;
            n--;
        }
        Node curr = size1-size2>0?head2:head1;
        while(curr!=temp){
            curr = curr.next;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 两链表都有环时找相交节点
     * 多种情况
     * 1、两链表入环之前相交（入环节点必相等）：使用两链表都无环时找相交节点思想，终点设为入环节点，可求相交节点
     * 2、两链表入环后相交（相交节点不相等）：直接从入环节点loop1遍历环，如果在环上能找到loop2则相交，否则两链表不相交
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */

    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        if(loop1==loop2){
            Node curr1 = head1;
            Node curr2 = head2;
            int size1 = 0,size2=0;
            while(curr1!=loop1){
                curr1 = curr1.next;
                size1++;
            }
            while (curr2!=loop2){
                curr2 = curr2.next;
                size2++;
            }
            Node temp = size1-size2>0?head1:head2;
            int n = Math.abs(size1-size2);
            while(n!=0){
                n--;
                temp = temp.next;
            }
            Node curr = size1-size2>0?head2:head1;
            while(temp!=curr){
                temp = temp.next;
                curr = curr.next;
            }
            return temp;
        }else {
            Node temp = loop1.next;
            while (temp!=loop1){
                if(temp==loop2){
                    return loop1;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    /**
     * 都有环时可能相交，都无环时可能相交，一个有环一个无环时不可能相交
     * @param head1
     * @param head2
     * @return
     */
    public static Node findIntersectNode(Node head1,Node head2){
        Node loopNode1 = findLoopNode(head1);
        Node loopNode2 = findLoopNode(head2);
        if (loopNode1==null&&loopNode2==null){
            return bothNoLoop(head1,head2);
        }
        if(loopNode1!=null&&loopNode2!=null){
            return bothLoop(head1,loopNode1,head2,loopNode2);
        }
        return null;
    }

    public static void main(String[] args) {
        Node headA = new Node(1);
        Node nodeA1 = new Node(2);
        Node nodeA2 = new Node(10);
        Node nodeA3 = new Node(11);
        Node nodeA4 = new Node(12);
        Node nodeA5 = new Node(13);

        headA.next = nodeA1;
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeA5.next = nodeA3;

        Node headB = new Node(3);
        headB.next = nodeA4;

        System.out.println(findIntersectNode(headA,headB).value);
    }
}
