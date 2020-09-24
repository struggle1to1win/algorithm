package com.algorithm.all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassNamePractice_ValuePartition
 * @Description 将链表根据某个值划分为大于、等于、小于区域
 * @Author Yao Xin
 * @Date2020/9/24 15:25
 **/
public class Practice_ValuePartition {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //使用六个节点分别记录大于、等于、小于区域的头尾节点，并将之串起来
    public static Node partitionBest(Node head,int p){
        if(head==null)return head;
        Node sH=null,sT=null,eH=null,eT=null,bH=null,bT=null;
        while(head!=null){
            Node temp = head.next;
            head.next = null;
            if(head.value>p){
                if (bT==null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = bT.next;
                }
            }else if(head.value<p){
                if (sT==null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = sT.next;
                }
            }else {
                if (eT==null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = eT.next;
                }
            }
            head = temp;
        }

        if(sT==null&&eT==null){
            return bH;
        }else if(sT==null){
            eT.next = bH;
            return eH;
        }else if(eT==null){
            sT.next = bH;
            return sH;
        }else {
            sT.next = eH;
            eT.next = bH;
            return sH;
        }
    }

    //将node转为数组直接使用荷兰国旗问题处理
    public static Node partitionSingleList(Node head,int p){
        int size = 0;
        Node temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        if (size==0||size==1)return head;
        int[] arr = new int[size];
        int index=0;
        while(head!=null){
            arr[index++] = head.value;
            head = head.next;
        }
        partition(arr,0,arr.length-1,p);

        Node newHead = new Node(arr[0]);
        Node node1 = newHead;
        for(int i=1;i<arr.length;i++){
            Node node =new Node(arr[i]);
            node1.next = node;
            node1 = node;
        }
        return newHead;
    }

    public static void partition(int[] arr,int l,int r,int p){
        if(l>=r){
            return;
        }
        int less = l-1;
        int more = r+1;
        int index = l;
        while (index<more){
            if(arr[index]<p){
                swap(arr,index++,++less);
            }else if(arr[index]>p){
                swap(arr,index,--more);
            }else {
                index++;
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(Node head){
        while(head!=null){
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static Node tranArrToList(int[] arr){
        if (arr==null||arr.length==0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node node = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            node.next = temp;
            node = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,6,5,3,1};
        Node head = tranArrToList(arr);

//        Node node = partitionSingleList(head, 3);
        Node node = partitionBest(head, 3);

        print(node);
    }
}
