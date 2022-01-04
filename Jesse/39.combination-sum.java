/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    public void backtrack(List<List<Integer>> res, LinkedList<Integer> current, int[] candidates, int remain, int start){
        if(remain == 0){
            res.add(new ArrayList<Integer>(current));
            return;
        }
        if(remain<0){
            return;
        }
                    
        for(int i =start;i<candidates.length;i++){
            current.add(candidates[i]);
            backtrack(res,current,candidates,remain-candidates[i],i);
            current.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new LinkedList<Integer>(),candidates,target,0);
        return res;
    }
}
// @lc code=end

