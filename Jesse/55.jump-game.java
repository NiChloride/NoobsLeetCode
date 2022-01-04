/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int farthest =0;
        int currentJumpEnd =0;
        for(int i=0;i<nums.length-1;i++){
            
            farthest = Math.max(farthest,i+nums[i]);
            if(i ==0){
                currentJumpEnd = nums[i];
            }
            
            if(i == currentJumpEnd){
                if(currentJumpEnd == farthest && farthest<nums.length){
                    return false;
                }
                currentJumpEnd = farthest;
            }
        }
        
        return true;
        
    }
}
// @lc code=end

