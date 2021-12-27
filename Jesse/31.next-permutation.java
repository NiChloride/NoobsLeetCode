/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        
        

        for(int i = nums.length-1; i-1>=0;i--){
            if(nums[i-1]< nums[i]){
                int j = nums.length-1;
                while(nums[j]<=nums[i-1]){
                    j --;
                }
                swap(nums,i-1,j);
                reverse(nums,i);
                return;
            }
        }
        System.out.println("123123123");
        reverse(nums,0);
        
    }
    
    void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    
    void reverse(int[] nums, int start){
        int n = nums.length-1;
        while(start<n){
            swap(nums,start++,n--);
        }
    }
}
// @lc code=end

