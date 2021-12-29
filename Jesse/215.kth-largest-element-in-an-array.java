/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
import java.util.Random;
class Solution {
    
    int[] nums;
    
    public void swap(int a, int b){
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }
    
    public int partition(int left, int right, int pivot_idx){
        int pivot = this.nums[pivot_idx];
        swap(right, pivot_idx);
        int current = left;
        
        for(int i =left;i<right;i++){
            if(pivot > this.nums[i]){
                swap(current, i);
                current ++;
            }
        }
        swap(current, right);
        return current;
    }
    
    
    public int quickselect(int left, int right, int k_smaller_nums) {
    
        if (left == right) return this.nums[left];  

   
        Random random_num = new Random();
        
        int pivot_idx = left + random_num.nextInt(right - left); 
    
        pivot_idx = partition(left, right, pivot_idx);

        if(k_smaller_nums == pivot_idx) return this.nums[pivot_idx];
        else if(k_smaller_nums < pivot_idx) return quickselect(left, pivot_idx-1,k_smaller_nums);
        return quickselect(pivot_idx+1, right,k_smaller_nums);
  }
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
  }   
    
}
// @lc code=end

