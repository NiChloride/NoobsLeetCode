/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            sum += nums[i];
            minSum = Math.min(sum, minSum);
        }
        
        return minSum <= 0? 1-minSum:1;
    }
}
// @lc code=end

