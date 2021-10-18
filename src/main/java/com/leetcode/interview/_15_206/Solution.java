package com.leetcode.interview._15_206;

import java.util.List;

// 206. https://leetcode.com/problems/reverse-linked-list/
public class Solution {

    public static void main(String[] args) {

        // input
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        // process
        ListNode answer = reverseList2(head);

        //output
        outputPrint(answer);

    }


    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev; //head

            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode prev, ListNode node) {

        if(node == null){
            return null;
        }
        ListNode next = node.next;
        node.next = prev;
        reverse(node, next);

        return prev;
    }

    public static void outputPrint(ListNode answer) {
        if (answer != null) {
            while (answer.next != null) {
                System.out.print(answer.val + ", ");
                answer = answer.next;
            }
            System.out.println(answer.val);
        }
    }


}
