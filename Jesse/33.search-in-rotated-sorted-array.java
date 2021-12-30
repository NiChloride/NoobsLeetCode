/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length ==0 || nums == null){
            return -1;
        }
        
        int left =0, right = nums.length-1, mid =0;
        while(left<right){
            mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid]<nums[left]){
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            else{
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        
        
        if(nums[left] == target) return left;
        return nums[right] == target? right:-1;
    }
}
// @lc code=end

