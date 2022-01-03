/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i = 1; i< prices.length;i++){
            dp[i] = dp[i-1] + Math.max(0,prices[i] - prices[i-1]);
        }
        return dp[prices.length-1];
        
    }
}
// @lc code=end

