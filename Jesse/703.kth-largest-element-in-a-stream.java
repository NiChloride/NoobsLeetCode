/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    int k;
    PriorityQueue<Integer> nums = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            this.nums.offer(num);
        }
        while(this.nums.size()>k){
            this.nums.poll();
        }
        
    }
    
    public int add(int val) {
        this.nums.offer(val);
        
        if(this.nums.size()>this.k){
            this.nums.poll();
        }
        
        
        return this.nums.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

