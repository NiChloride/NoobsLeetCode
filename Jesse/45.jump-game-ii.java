/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        
        return steps(nums, nums.length-1, new int[nums.length]);
    }
    
    int steps(int[] nums, int current, int[] buffer){
        if(current <= 1){
            return current;
        }
        if(buffer[current] != 0){
            return buffer[current];
        }
        int shortest = Integer.MAX_VALUE;
        for(int i =1; i<=current;i++){
            if(nums[current - i]>= i){
                shortest = Math.min(shortest,steps(nums,current-i,buffer)+1);
            }
        }
        buffer[current] = shortest;
        
        return shortest;
    }
}
// @lc code=end

