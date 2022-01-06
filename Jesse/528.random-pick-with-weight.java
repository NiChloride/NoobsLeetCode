/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    int[] prefixSum;
    int total;
    public Solution(int[] w){
        this.prefixSum = new int[w.length];
        int prefixSum = 0;
        for(int i =0; i<w.length;i++){
            prefixSum += w[i];
            this.prefixSum[i] = prefixSum;
        }
        this.total = prefixSum;
    }
    
    public int pickIndex(){
        
        double target =this.total * Math.random();
        
        int left =0, right = this.prefixSum.length-1, mid =0;
        while(left<right){
            mid = left + (right-left)/2;
            if(target<prefixSum[mid]){
                right = mid;
            }
            else{
                left = mid +1;
            }
        
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

