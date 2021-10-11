package com.leetcode.interview._14_021;

import java.util.Comparator;

// 021. https://leetcode.com/problems/merge-two-sorted-lists/
public class Solution {

    public static void main(String[] args) {

        // 1. input (1)
        ListNode l1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));
        ListNode l2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));
        // 1. input (2)
//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode();

        // 2. solution
        ListNode answer = mergeTwoLists(l1, l2);

        // 3. output
        while (answer.next != null) {
            System.out.print(answer.val + ", ");
            answer = answer.next;
        }
        System.out.print(answer.val);

    }

    // 정렬된 두개의 linked list를 병합
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 출력 참고
//        outputPrint(l1);
//        outputPrint(l2);
//        System.out.println();

        // 1. l1, l2 비교해서 l1에 들어가는 값이 작은 값이 들어가도록 스왑 해준다.
        if(l1 == null || l2 != null && l1.val > l2.val){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }

        // 2. l1은 항상 작은 값으로 next로 넣는다.
        if(l1 != null){
            l1.next = mergeTwoLists(l1.next,l2);
        }

        return l1;
    }

    public static void outputPrint(ListNode answer) {
        while (answer.next != null) {
            System.out.print(answer.val + ", ");
            answer = answer.next;
        }
        System.out.println(answer.val);
    }

    public static void outputPrint(ListNode answer, String name) {
        System.out.print(name + " : ");
        while (answer.next != null) {
            System.out.print(answer.val + ", ");
            answer = answer.next;
        }
        System.out.println(answer.val);
    }

}
