/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length-1;
        int R = 1;
        int[] answer = new int[nums.length];
        answer[0] = nums[0];
        
        for(int i =1; i<=size;i++){
            answer[i] = answer[i-1]*nums[i];
        }
        
        for(int j =size; j>=0;j--){
            if(j>0 && j<size){
                R *= nums[j+1];
                answer[j] = answer[j-1]*R;
            }
            else if(j ==size){
                answer[j] = answer[j-1];
            }
            
        }
        answer[0] = 1;
        for(int k=1;k<=size;k++){
            answer[0] *= nums[k];
        }
        return answer;
    }
}
// @lc code=end

