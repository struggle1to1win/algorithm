/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package com.algorithm.all.leetCode;

/**
 * @ClassNameLinkedListInsertSort147
 * @Description
 * @Author Yao Xin
 * @Date2020/11/20 9:10
 **/
public class LinkedListInsertSort147 {


    public static ListNode insertionSortList(ListNode head) {
        ListNode right = head;
        ListNode curr = head;
        while(curr!=null){
            ListNode comparePre = null;
            ListNode compareCurr = head;
            do{
                if(curr.val<compareCurr.val){
                    right.next = curr.next;
                    curr.next = compareCurr.next;
                    if(comparePre!=null){
                        comparePre.next = curr;
                    }
                    break;
                }else {
                    comparePre = compareCurr;
                    compareCurr = compareCurr.next;
                }
            }while (compareCurr!=null&&curr!=null&&comparePre!=right);
            right = compareCurr==right?right.next:right;
            curr = right.next;
        }
        return head;
    }

    public static void print(ListNode head){
        ListNode curr = head;
        String s="";
        while (curr!=null){
            s = s+curr.val+"->";
            curr = curr.next;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode listNode = insertionSortList(head);

        print(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
