package com.leetcode.interview._9_015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 015. https://leetcode.com/problems/3sum/
public class Solution {

    public static void main(String[] args) {

        List<List<Integer>> answer;

//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-2,0,0,2,2};

        answer = threeSum(nums);

        // answer is '3 sum = 0'
        System.out.println("answer : " + answer);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            // 기준이 되는 i의 중복 제거.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int threeSum = nums[left] + nums[i] + nums[right];
                if (threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    List<Integer> element = new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[right]));
                    answer.add(element);

                    // answer가 나왔을때 left & right에 대한 중복 제거
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    left++;
                    right--;
                }
            }
        }
        return answer;
    }
}
