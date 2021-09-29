package com.leetcode.interview._13_234;

import java.util.ArrayList;
import java.util.List;

// 234. https://leetcode.com/problems/palindrome-linked-list/
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

        boolean answer = isPalindrome(head);
        System.out.println("answer : " + answer);

    }

    public static boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);

        for (int i = 0; i < list.size() / 2; i++) {
            int l = 0 + i;
            int r = list.size() - 1 - i;
            if(!(list.get(l) == list.get(r))){
                return false;
            }
        }

        return true;
    }
}
