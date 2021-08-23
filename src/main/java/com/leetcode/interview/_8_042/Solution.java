package com.leetcode.interview._8_042;

// 042. https://leetcode.com/problems/trapping-rain-water/
public class Solution {

    public static void main(String[] args) {

//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // answer = 6
//        int[] height = {0, 2, 0}; // answer = 0
//        int[] height = {2, 0, 2}; // answer = 2
//        int[] height = {4, 2, 3}; // answer = 2
        int[] height = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6};  // answer = 23


        int answer = trap(height);
        System.out.println(answer);

    }

    public static int trap(int[] height) {
        int answer = 0;

        int startIdx = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[startIdx] <= height[i]) {
                answer += blueSectionCounter(height, startIdx, i);
                startIdx = i;
            }
        }

        int endIdx = startIdx;
        startIdx = height.length - 1;
        for (int i = height.length - 2; i >= endIdx; i--) {
            if (height[startIdx] <= height[i]) {
                answer += blueSectionCounter(height, i, startIdx);
                startIdx = i;
            }
        }
        return answer;

    }

    public static int blueSectionCounter(int[] height, int startIdx, int endIdx) {
        int blueSectionCount = 0;
        int minHeight = Math.min(height[startIdx], height[endIdx]);
        for (int i = startIdx + 1; i < endIdx; i++) {
            blueSectionCount += minHeight - height[i];
        }
        return blueSectionCount;
    }
}
