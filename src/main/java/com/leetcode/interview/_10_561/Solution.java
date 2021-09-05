package com.leetcode.interview._10_561;

import java.util.Arrays;

// 561. https://leetcode.com/problems/array-partition-i/
public class Solution {

    public static void main(String[] args) {

        int[] nums = {6, 2, 6, 5, 1, 2};
        int answer = arrayPairSum(nums);

        System.out.println("answer : " + answer);

    }

    public static int arrayPairSum(int[] nums) {

        int answer = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            answer += nums[i];
        }

        return answer;
    }
}
