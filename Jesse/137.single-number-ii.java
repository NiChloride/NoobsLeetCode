/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int xor_once = 0;
        int xor_twice = 0;
        
        for(int num : nums){
              xor_once = ~xor_twice & (xor_once ^ num);
              xor_twice = ~xor_once & (xor_twice ^ num);
        }
        
        return xor_once;
    }
}
// @lc code=end

