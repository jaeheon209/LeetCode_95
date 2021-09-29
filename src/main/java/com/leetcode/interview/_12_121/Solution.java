package com.leetcode.interview._12_121;

// 121. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Solution {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int answer = maxProfit(prices);
        System.out.println("answer : " + answer);

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - min;

            //profit = Math.max(profit, prices[i] - min);
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            //min = Math.min(prices[i], min);
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
    // Math 함수를 사용하여 코드를 조금더 깔끔하게 작성.
}
