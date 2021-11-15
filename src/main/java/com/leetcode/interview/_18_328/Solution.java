package com.leetcode.interview._18_328;


// 328. https://leetcode.com/problems/odd-even-linked-list/
public class Solution {

    public static void main(String[] args) {
        // input case 1
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)))))));

        // input case 2
        ListNode head2 = new ListNode(2,
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(5,
                                        new ListNode(6,
                                                new ListNode(4,
                                                        new ListNode(7)))))));

        ListNode answer = oddEvenList(head2);
        outputPrint(answer);

    }

    public static ListNode oddEvenList(ListNode head) {

        ListNode first = head;
        ListNode oddEndPoint = head.next;
        ListNode even = head.next;

        while(head.next != null){
            head.next = head.next.next;
            head.next = head.next.next;
            even.next = even.next.next;

            head = head.next;
            even = even.next;
        }
        head.next = oddEndPoint;
        return first;
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
