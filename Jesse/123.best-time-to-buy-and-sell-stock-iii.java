/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        
        
        int n = prices.length;
        if(n <= 1) return 0;
        
        int[] leftMost = new int[n];
        int[] rightMost = new int[n+1];
        
        int leftMin = prices[0];
        int rightMax = prices[n-1];
        
        
        for(int i =1; i<n;i++){
            leftMost[i] = Math.max(leftMost[i-1], prices[i]-leftMin);
            if(prices[i]<leftMin){
                leftMin = prices[i];
            }
            
            rightMost[n-i-1] = Math.max(rightMost[n-i], rightMax-prices[n-i-1]);
            if(prices[n-i-1]>rightMax){
                rightMax = prices[n-i-1];
            }
        }
        
        int res =0;
        
        for(int j =0; j<n; j++){
            res = Math.max(res,leftMost[j]+rightMost[j+1]);
        }
        
       
        
        return res;
        
    }
}
// @lc code=end

