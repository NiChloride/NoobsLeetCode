/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    void backtracking(List<List<Integer>> res, LinkedList<Integer> current, int[] nums){
        if(current.size() == nums.length){
            res.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i =0;i<nums.length;i++){
            if(!current.contains(nums[i])){
                current.add(nums[i]);
                backtracking(res,current,nums);
                current.removeLast();
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new LinkedList<Integer>(), nums);
        return res;
    }
}
// @lc code=end

