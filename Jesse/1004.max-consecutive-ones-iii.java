/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) { 
        if(nums.length ==0 || nums == null){
            return 0;
        }
        
        int size = 0;
        int left =0;
        int count =0;
        
        for(int i =0;i<nums.length;i++){
            
            if(nums[i] == 0) count++;
            while(left<=i && count> k){
                
                if(nums[left] == 0){
                    count --;
                }
                left ++;
            }
            size = Math.max(size, i - left +1);
        }
        
        return size;
        
    }
}
// @lc code=end

