/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i =1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        for(int j =n-2;j>=0;j--){
            right[j] = Math.max(right[j+1], height[j]);
        }
        
        int res =0;
        for(int k=1;k<n-1;k++){
            res += Math.max(0,(Math.min(left[k-1],right[k+1]) - height[k]));
        }
        return res;
    }
}
// @lc code=end

