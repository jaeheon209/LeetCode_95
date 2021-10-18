package com.leetcode.interview._16_002;

// 002. https://leetcode.com/problems/add-two-numbers/
public class Solution {

    public static void main(String[] args) {

        // input case 1
//        ListNode l1 = new ListNode(2,
//                new ListNode(4,
//                        new ListNode(3)));
//
//        ListNode l2 = new ListNode(5,
//                new ListNode(6,
//                        new ListNode(4)));

        // input case 1
        ListNode l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)))))));

        ListNode l2 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9))));


        ListNode answer = addTwoNumbers(l1, l2);
        outputPrint(answer);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    public static ListNode add(ListNode l1, ListNode l2, int carry) {
        // node length swap
        if (l1 == null && l2 != null) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }

        // l2 null check
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        // base case
        if (l1 == null && carry == 1) {
            return new ListNode(1);
        }else if (l1 != null) {
            // recursive case
            int sum = l1.val + l2.val + carry;

            // carry
            int addCarry = sum / 10 ;
            l1.val = sum % 10;

            // recursive
            l1.next = add(l1.next, l2.next, addCarry);
        }

        return l1;
    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode root = head;

        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;

            // l1 add
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // l2 add
            if (l2 != null) {
                sum += l2.val;
                l1 = l2.next;
            }

            // carry
            carry = (sum + carry) / 10;
            int val = (sum + carry) % 10;
            head.next = new ListNode(val);
            head = head.next;
        }


        return root.next;
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
