package com.leetcode.interview._7_001;

import java.util.HashMap;
import java.util.Map;

// 001. https://leetcode.com/problems/two-sum/
public class Solution {

    public static void main(String[] args) {
//        # 문제 분석
//        - int nums, target
//        - nums의 두 숫자를 더해서 target!
//        - target이 되는 nums의 두 index를 리턴
//        - 정확하게 하나의 해결책만있고, 같은 원소(인덱스)를 2번사용 못한다.


        //case1
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        //case2
//        int[] nums = {-3,4,3,90};
//        int target = 0;

//        int[] answers1 = twoSumByBrute(nums, target);
//        System.out.print("twoSumByBrute answer : ");
//        for (int answer : answers1) {
//            System.out.print(answer+" ");
//        }
//        System.out.println();

        int[] answers2 = twoSumByHashMap(nums, target);
        System.out.print("twoSumByHashMap answer : ");
        for (int answer : answers2) {
            System.out.print(answer+" ");
        }
        System.out.println();

    }


    // 50ms
    public static int[] twoSumByBrute(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    // 3ms
    public static int[] twoSumByHashMap(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (numsMap.get(nums[i]) != null) {
                answer[0] = i;
                answer[1] = numsMap.get(nums[i]);
                return answer;
            } else {
                numsMap.put(key, i);
            }
        }
        return answer;
    }
}
