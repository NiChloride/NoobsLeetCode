/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new LinkedList<Integer>(),nums,0);
        return res;
    }
    
    void backtracking(List<List<Integer>> res, LinkedList<Integer> current, int[] nums, int index){
        res.add(new ArrayList<Integer>(current));
        if(index>=nums.length){
            return;
        }
        
        
        
        for(int start = index; start<nums.length; start++){
            current.addLast(nums[start]);
            backtracking(res,current,nums,start+1);
            current.removeLast();
        }
        
    }
}
// @lc code=end

