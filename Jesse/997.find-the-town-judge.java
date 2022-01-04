/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        
        if(trust.length<n-1){
            return -1;
        }
        
        if(trust.length == 0 && n == 1){
            return 1;
        }
        
        Map<Integer,Integer> people = new HashMap<>();
        
        for(int[] t : trust){
            people.put(t[0],people.getOrDefault(t[0],0) -1);
            people.put(t[1],people.getOrDefault(t[1],0) +1);
        }
        
        for(int k : people.keySet()){
            if(people.get(k) == n-1){
                return k;
            }
        }
        
        return -1;
    }
}
// @lc code=end

