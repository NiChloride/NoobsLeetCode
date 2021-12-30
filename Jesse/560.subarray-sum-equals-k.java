/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> helper = new HashMap<>();
        int ans =0, sum =0;
        for(int i =0; i< nums.length;i++){
            
            sum+=nums[i];
            if(sum == k){
                ans+=1;
            }
            if(helper.containsKey(sum-k)){
                ans+= helper.get(sum-k);
            }
            helper.put(sum,helper.getOrDefault(sum,0) + 1);
        }
        
        return ans;
    }
}
// @lc code=end

