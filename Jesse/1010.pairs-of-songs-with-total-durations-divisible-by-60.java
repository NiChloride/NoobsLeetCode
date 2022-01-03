/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] buffer = new int[60];
        int res =0;
        for(int t : time){
            if(t%60 == 0){
                res += buffer[0];
            }
            else{
                res += buffer[60-t%60];
            }
            
            buffer[t%60] += 1;
        }
        
        return res;
    }
}
// @lc code=end

