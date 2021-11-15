package com.leetcode.interview._17_024;

// 024. https://leetcode.com/problems/swap-nodes-in-pairs/
public class Solution {

    public static void main(String[] args) {
        // input case 1
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));

        // input case 2
//        ListNode head = new ListNode();

//        // input case 3
//        ListNode head = new ListNode(1);


//        // input case 4
//        ListNode head = new ListNode(0,
//                new ListNode(4,
//                        new ListNode(9,
//                                new ListNode(2))));

        //        // input case 5
//        ListNode head = new ListNode(2,
//                new ListNode(2,
//                                new ListNode(0))));
        ListNode answer = swapPairs(head);

        outputPrint(answer);


    }

    public static ListNode swapPairs(ListNode head) {

        //base case
        // 1. head null
        // 1. head 홀수라서 1개가 들어온케이스

        //짝수
        if (head == null || head.val == 0 && head.next == null) {
            return null;
        }

        //홀수
        //1) 정말 홀수
        //2) 객체만 있는 상테인경우
        if (head.next == null) {
            return head;
        }

        //swap case & recursive
        ListNode recursiveNode = head.next.next;

        //swap
        ListNode newHead = new ListNode();
        newHead = head.next;

        newHead.next = head;
        newHead.next.next = swapPairs(recursiveNode);

        return newHead;

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
