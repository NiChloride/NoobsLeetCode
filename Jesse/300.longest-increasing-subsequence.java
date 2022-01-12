/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1;i<nums.length;i++){
            int temp = 1;
            for(int j =i-1;j>=0;j--){
                if(nums[i] > nums[j]){
                    temp = Math.max(temp, dp[j]+1);
                }
            }
            dp[i] = temp;
        }
        
        int res =0;
        for(int m = 0;m<dp.length;m++){
            res = Math.max(res,dp[m]);
        }
        
        return res;
    }
}
// @lc code=end

