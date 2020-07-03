package com.liu.sourceProject.leetcode.number300;

public class Number309 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i -1][0] - prices[i],dp[i-1][1]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }
}
