/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    int[] nums;
    ArrayDeque<Integer> buffer = new ArrayDeque<Integer>();
    
    void queProcessing(int i, int k){
        if(!this.buffer.isEmpty() && buffer.getFirst() == i-k){
            this.buffer.removeFirst();
        }
        
        while(!this.buffer.isEmpty() && this.nums[buffer.getLast()]< this.nums[i]){
            buffer.removeLast();
        } 
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1){
            return nums;
        }
        if(nums.length ==0 || k ==0){
            return new int[0];
        }
        int max_idx = 0;
        this.nums = nums;
        int[] res = new int[nums.length-k+1];
        
        for(int m=0;m<k;m++){
            queProcessing(m,k);
            this.buffer.addLast(m);
            if(nums[m]>nums[max_idx]) max_idx = m;
        }
        
        res[0] = nums[max_idx];
        
        for(int i =k;i<nums.length;i++){
            queProcessing(i,k);
            this.buffer.addLast(i);
            max_idx = this.buffer.getFirst();
            res[i-k+1]= nums[max_idx];
        }
        return res;
    }
}
// @lc code=end

