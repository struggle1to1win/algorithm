package com.algorithm.all.linkedList;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassNamePractice_LinkedList
 * @Description 链表基础题目练习
 * @Author Yao Xin
 * @Date2020/9/15 10:39
 **/
public class Practice_LinkedList {

    //反转单向列表
    public static SinglyNode inverseSinglyList(SinglyNode head){
        SinglyNode next;
        SinglyNode pre=null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //反转双向链表
    public static DoubleNode inverseDoubleList(DoubleNode head){
        DoubleNode next;
        DoubleNode pre = null;
        while(head!=null){
            next = head.next;
            head.pre = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //删除链表中某个数
    public static SinglyNode deleteNum(SinglyNode head,int num){
        int index=0;
        while(head.getData()==num){
            index++;
            head=head.next;
        }
        SinglyNode curr = head;

        SinglyNode pre = null;
        while(head!=null){
            if(head.getData()==num){
                pre.next = head.next;
            }else {
                pre = head;
            }
            head =  head.next;
        }
        return curr;
    }


    public static void main(String[] args) {
        //反转单向链表
//        SinglyNode head = generateSinglyList();
//        printList(head);
//        SinglyNode result = inverseSinglyList(head);
//        printList(result);
        //反转双向链表
//        DoubleNode doubleNode = generateDoubleList();
//        DoubleNode doubleNode1 = inverseDoubleList(doubleNode);
//        printList(doubleNode1);
        //删除链表中的某个数
        SinglyNode head = generateSinglyList();
        SinglyNode singlyNode = deleteNum(head, 1);
        printList(singlyNode);
    }

    //生成双向链表
    public static DoubleNode generateDoubleList(){
        DoubleNode head = new DoubleNode(1);
        DoubleNode n1 = new DoubleNode(2);
        DoubleNode n2 = new DoubleNode(3);
        DoubleNode n3 = new DoubleNode(4);
        DoubleNode n4 = new DoubleNode(5);
        DoubleNode n5 = new DoubleNode(6);
        head.next=n1;head.pre=null;
        n1.next=n2;n1.pre=head;
        n2.next=n3;n2.pre=n1;
        n3.next=n4;n3.pre=n2;
        n4.next=n5;n4.pre=n3;
        return head;
    }

    //生成单向链表
    public static SinglyNode generateSinglyList(){
        SinglyNode head = new SinglyNode(1);
        SinglyNode n1 = new SinglyNode(1);
        SinglyNode n2 = new SinglyNode(3);
        SinglyNode n3 = new SinglyNode(4);
        SinglyNode n4 = new SinglyNode(1);
        SinglyNode n5 = new SinglyNode(6);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return head;
    }

    //打印双向链表
    public static void printList(DoubleNode head){
        DoubleNode last=null;
        while(head!=null){
            System.out.println(head.getData());
            last=head;
            head=head.next;
        }

        while(last!=null){
            System.out.println(last.getData());
            last=last.pre;
        }
    }

    //打印单向链表
    public static void printList(SinglyNode head){
        while(head!=null){
            System.out.println(head.getData());
            head=head.next;
        }
    }
}

@Getter
@Setter
class SinglyNode{
    private int data;
    public SinglyNode next;

    public SinglyNode(int data, SinglyNode next) {
        this.data = data;
        this.next = next;
    }

    public SinglyNode(int data) {
        this.data = data;
    }

    public SinglyNode() {
    }
}
@Getter
@Setter
class DoubleNode<T>{
    private T data;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(T data) {
        this.data = data;
    }
}
