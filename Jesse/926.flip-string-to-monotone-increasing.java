/*
 * @lc app=leetcode id=926 lang=java
 *
 * [926] Flip String to Monotone Increasing
 */

// @lc code=start
class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int[] P = new int[s.length()+1];
        
        for(int i =0; i<s.length();i++){
            P[i+1] = s.charAt(i) == '0'? P[i]:P[i]+1;
        }
        
        int res = Integer.MAX_VALUE;
        int n = s.length();
            
        for(int j =0; j<=n; j++){
            int zeros = (n-j) - (P[n]-P[j]);
            int ones = P[j];
            System.out.println(ones);
            res = Math.min(res, ones + zeros);
        }
        
        return res;
    }
}
// @lc code=end

